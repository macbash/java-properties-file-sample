
package com.azfar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App3 {

    public static void main(String[] args) {

    	String env_name = System.getProperty("env_name","dev") + ".properties";
        try (InputStream input = App3.class.getClassLoader().getResourceAsStream(env_name)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));
            System.out.println(System.getProperty("env_name"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
