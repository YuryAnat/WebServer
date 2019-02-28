package utilities;

import exceptions.ReadPropertyException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
    private static final String CONFIG_FILE = "/config.properties";
    private Properties properties = new Properties();

    public Properties getConfig() throws ReadPropertyException {
        try {
            properties.load(ReadConfigFile.class.getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            throw new ReadPropertyException("Error read properties file " + CONFIG_FILE);
        }
        return properties;
    }
}
