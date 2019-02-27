package repositories;

import connections.JdbcConnection;
import exceptions.DBException;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbcImpl implements UserRepository {

    private Connection connection;

    public UserRepositoryJdbcImpl(){
        connection = JdbcConnection.getConnection();
    }

    @Override
    public boolean addUser(User user) {
        boolean status = false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into users (login, password, name, email) values (?,?,?,?)");
            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getName());
            statement.setString(4,user.getEmail());
            int result = statement.executeUpdate();
            if (result > 0) status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateUser(User user) {
        boolean status = false;
        try {
            PreparedStatement statement = connection.prepareStatement("update users set login = ?, password =?" +
                    ", name = ?, email = ? where id=?");
            statement.setInt(1,user.getId());
            statement.setString(2,user.getLogin());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getName());
            statement.setString(5,user.getEmail());
            int result = statement.executeUpdate();
            if (result > 0) status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean status = false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from users where id = ?");
            statement.setInt(1,id);
            int result = statement.executeUpdate();
            if (result > 0) status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where id = ?");
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                user = new User(result.getInt("id"),result.getString("login")
                        ,result.getString("password"),result.getString("name")
                        ,result.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByName(String login) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from users where login = ?");
            statement.setString(1,login);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                user = new User(result.getInt("id"),result.getString("login")
                        ,result.getString("password"),result.getString("name")
                        ,result.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("select * from users");
            list = new ArrayList<>();
            while (result.next()){
                list.add(new User(result.getInt("id"),result.getString("login")
                        ,result.getString("password"),result.getString("name")
                        ,result.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
