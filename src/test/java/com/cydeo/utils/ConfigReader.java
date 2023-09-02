package com.cydeo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties property = new Properties();
    static{
        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            property.load(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return property.getProperty(key);
    }

}
