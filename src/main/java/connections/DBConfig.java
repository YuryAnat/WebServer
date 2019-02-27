package connections;

public class DBConfig {
    private String host = "localhost";
    private String port = "5432";
    private String base = "crud";
    private String user = "postgres";
    private String pass = "1234";

    public DBConfig() {
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getBase() {
        return base;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}