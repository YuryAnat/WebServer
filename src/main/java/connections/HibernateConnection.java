package connections;

import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection{

    private static SessionFactory sessionFactory = null;

    private HibernateConnection(){
    }

    public static SessionFactory getSessionFactory(){
        DBConfig conf = new DBConfig();
        if (sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://" + conf.getHost() + ":" + conf.getPort() + "/" + conf.getBase());
            configuration.setProperty("hibernate.connection.username", conf.getUser());
            configuration.setProperty("hibernate.connection.password", conf.getPass());
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "validate");
            configuration.setProperty("connection_pool_size","10");
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
