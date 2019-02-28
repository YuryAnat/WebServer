package factorys;

import repositories.UserRepository;
import repositories.UserRepositoryHibernateImpl;
import repositories.UserRepositoryJdbcImpl;
import utilities.ReadConfigFile;
import java.util.Properties;

public class UserRepositoryFactory {
    private Properties properties = new Properties();
    private UserRepository repository;

    public UserRepositoryFactory(){
        ReadConfigFile readConfigFile = new ReadConfigFile();
        properties = readConfigFile.getConfig();
    }

    public UserRepository getRepository() {
//        if (properties.getProperty("typeConnection").equals("jdbc")){
//            return new UserRepositoryJdbcImpl();
//        }else if (properties.getProperty("typeConnection").equals("hibernate")){
//            return new UserRepositoryHibernateImpl();
//        }else {
//            throw new ReadPropertyException("No properties type connections");
//        }
        switch (properties.getProperty("typeConnection")){
            case "jdbc" :
                repository = new UserRepositoryJdbcImpl();
                break;
            case "hibernate" :
                repository =  new UserRepositoryHibernateImpl();
                break;
            default:
                repository = new UserRepositoryJdbcImpl();
                break;
        }
        return repository;
    }
}
