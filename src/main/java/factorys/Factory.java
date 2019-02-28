package factorys;

import utilities.ReadConfigFile;
import java.util.Properties;

public class Factory {

    public static AbstractFactory getFactory(){
        Properties properties = new ReadConfigFile().getConfig();
        String type = properties.getProperty("type");
        if (type.equals("jdbc")){
            return new JdbcFactory();
        }else if (type.equals("hibernate")){
            return new HibernateFactory();
        }
        throw new RuntimeException("No found connection by type: " + type);
    }
}
