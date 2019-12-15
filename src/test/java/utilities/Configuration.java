package utilities;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    // it is reader of the properties files. and will be get the data from there.
    //It keeps sensitive datas which are user name, password,url, web applications etc.
    // This is the purpose of the Configuration class.

    public static String getProperties(String key) throws IOException {
        //specify the needed file
        File credsFile = new File("src/test/resources/conf/Configuration.properties");

        //read from a file
        FileReader fileReader = new FileReader(credsFile);

        Properties properties = new Properties();
        properties.load(fileReader);

        String value = properties.getProperty(key);
        return value;
    }
}