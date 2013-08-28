package youngjin.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Database에서 FileConfig으로 변경
 * - resource 폴더에 있는 maildata.txt를 읽어드림
 */
public class FileConfig {
    private FileConfig() {
    }
    public static Properties getProperties(String dbname) { 
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
