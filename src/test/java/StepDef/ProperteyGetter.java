package StepDef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProperteyGetter {
 private    Properties properties;
 private static ProperteyGetter getter;
   private ProperteyGetter() throws IOException {
        InputStream inputStream=new FileInputStream("src/test/java/config/config.properties");
        properties=new Properties();
        properties.load(inputStream);
    }
    public static ProperteyGetter getInstance() throws IOException {
        if (getter ==null)
        {
            getter=new ProperteyGetter();
            return getter;
        }
        else {
            return  getter;
        }
    }
    public String getUrl()
    {
        return properties.getProperty("base_url");
    }
}
