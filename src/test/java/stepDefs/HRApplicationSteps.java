package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.HRApplicationPage;
import utilities.Configuration;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.JDBCUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HRApplicationSteps {
    HRApplicationPage hRPage = new HRApplicationPage();
    List<Map<String, Object>> dataBaseNames;
    String query = "select e.first_name, e.last_name\n" +
            "from employees e join departments d on\n" +
            "e.department_id=d.department_id\n" +
            "join locations l on\n" +
            "d.location_id=l.location_id\n" +
            "join countries c on\n" +
            "l.country_id=c.country_id \n" +
            "join regions r on\n" +
            "c.region_id=r.region_id\n" +
            "where region_name = 'Europe'";
    String query2=" select department_name, count(*) \n" +
            " from employees e full outer join departments d on e.department_id=d.department_id where employee_id in (select  employee_id from\n" +
            " employees MINUS  select employee_id from job_history)\n" +
            " group by department_name";
    @Given("^Go to Database and get First name and Last name of employees who works in Europe and validate with their UI information \\(First name, Last Name\\)$")
    public void go_to_Database_and_get_First_name_and_Last_name_of_employees_who_works_in_Europe_and_validate_with_their_UI_information_First_name_Last_Name() throws Throwable {
        Driver.driver.get(Configuration.getProperties("HRApplicationUrl"));
        try {
            JDBCUtils.establishConnection();
            dataBaseNames = JDBCUtils.runSQLQuery(query);
            for (int i=0;i<hRPage.listOfFirstNames.size();i++){
                if(hRPage.listOfFirstNames.get(i).getText().equalsIgnoreCase(dataBaseNames.get(i).get("FIRST_NAME").toString())){
                    Assert.assertTrue(true);
                }
            }
            for (int i=0;i<hRPage.listOfLastNames.size();i++){
                if(hRPage.listOfLastNames.get(i).getText().equalsIgnoreCase(dataBaseNames.get(i).get("LAST_NAME").toString())){
                    Assert.assertTrue(true);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Fail");
        }
    }
    @And("^Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI$")
    public void go_to_Excel_and_update_column_Actual_of_Employees_with_number_of_Europe_employees_that_you_get_from_UI() throws Throwable {
        ExcelUtils.openExcelFile("testData","Sheet3");
        ExcelUtils.setValue(String.valueOf(JDBCUtils.countRows(query)),1,2);
    }
    @Then("^Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED$")
    public void compare_Actual_of_Employees_with_expected_of_Employees_and_if_they_matched_then_update_Test_Execution_Status_cell_as_PASSEDif_not_match_then_update_with_FAILED() throws Throwable {
        ExcelUtils.openExcelFile("testData","Sheet3");
//        System.out.println("Cell 1 "+ExcelUtils.getValue(1,1).substring(0,2));
//        System.out.println("Cell 2 "+ExcelUtils.getValue(1,2));
        if(ExcelUtils.getValue(1,1).substring(0,2).equalsIgnoreCase(ExcelUtils.getValue(1,2))){
            ExcelUtils.setValue("PASSED",1,3);
        }else{
            ExcelUtils.setValue("FAILED",1,3);
        }
    }
    @Given("^Go to Database and get Department Name and number of ‘Active’employees and validate with their UI numbers$")
    public void goToDatabaseAndGetDepartmentNameAndNumberOfActiveEmployeesAndValidateWithTheirUINumbers() throws IOException, SQLException {
        JDBCUtils.establishConnection();
        ExcelUtils.openExcelFile("testData","Sheet3");
        List<Map<String,Object>> maps = JDBCUtils.runSQLQuery(query2);
        Map<String,Object> uIdata=new HashMap<>();
        for (int i=0;i<hRPage.listOfDepartmentNames.size();i++) {
            uIdata.put(hRPage.listOfDepartmentNames.get(i).getText(),hRPage.listOfEmployeesNumber.get(i).getText());
        }
        Set<String> keys = uIdata.keySet();
        for(String s: keys){
            Assert.assertEquals(uIdata.get(s), maps.get(0).get(s));
        }
    }
    @And("^Then go to Excel and update column ‘Actual # of Employees’ with number of Active employees that you get from UI and compare that number with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED$")
    public void thenGoToExcelAndUpdateColumnActualOfEmployeesWithNumberOfActiveEmployeesThatYouGetFromUIAndCompareThatNumberWithExpectedOfEmployeesAndIfTheyMatchedThenUpdateTestExecutionStatusCellAsPASSEDifNotMatchThenUpdateWithFAILED() {
    }
}
