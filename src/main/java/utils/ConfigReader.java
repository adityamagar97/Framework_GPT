package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public static Properties getProperties() {
        if (prop == null) {
            try {
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
                prop.load(fis);
                System.out.println("Config file loaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error loading config file.");
            }
        }
        return prop;
    }

    public static String get(String key) {
        return getProperties().getProperty(key);
    }
}
