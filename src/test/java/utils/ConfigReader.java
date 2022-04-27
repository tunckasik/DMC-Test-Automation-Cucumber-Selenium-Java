package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    /*This class is used to read config.properties file*/
    //Create Properties object
    private static Properties properties;

    //Using static block to run this code before the methods
    static {
        //path of the properties file
        String path = "config.properties";
        try {
            //opening the file
            FileInputStream fileInputStream = new FileInputStream(path);
            //instantiated the properties object
            properties = new Properties();
            //Loading the file
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//ending static block

    //Writing the method
    //it will take key and return the value

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        return value;

        //return properties.getProperty(key);
    }
    public static final int DEFAULT_EXPLICIT_TIMEOUT = 10;

    public static final String DEFAULT_WEBSITE_HOMEPAGE = "https://devamc.com";
}
