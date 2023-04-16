package config;

import java.io.*;
import java.util.Properties;

public class Config {
    private Properties properties;

    public Config() {
        properties = getProperties();
    }

    private Properties getProperties(){
        Properties p = new Properties();
        try {
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("config.properties");
            p.load(inputStream);

//            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/config.properties"));
//            String initialString  = bufferedReader.readLine();
//            InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
//            p.load(targetStream);

        } catch (IOException e) {
            throw new RuntimeException("Cannot load properties file: " + e);
        }
        return p;
    }


    public String getApplicationUrl(){
        return properties.getProperty("application.url");
    }

    public String getUsername(){
        return properties.getProperty("application.user");
    }

    public String getPassword(){
        return properties.getProperty("application.password");
    }

}
