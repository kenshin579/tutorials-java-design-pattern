package youngjin.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileConfig {
    private FileConfig() {
    }

    public static Properties getProperties(String dbname) {
        String dirname = "facade/src/main/resources/";
        String filename = dirname + dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}