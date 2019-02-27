package services;

import models.User;
import repositories.UserRepository;
import repositories.UserRepositoryHibernateImpl;
import repositories.UserRepositoryJdbcImpl;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryJdbcImpl();
//    private UserRepository userRepository = new UserRepositoryHibernateImpl();

    private static UserServiceImpl service;

    private UserServiceImpl(){
    }

    public static UserService getInstance(){
        if (service == null){
            return new UserServiceImpl();
        }else {
            return service;
        }
    }

    public void addNewUser(User user){
        userRepository.addUser(user);
    }

    public void updateUser(User user){
        userRepository.updateUser(user);
    }

    public void deleteUser(int id){
        userRepository.deleteUser(id);

    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User getUserByID(int id){
        return userRepository.getUserById(id);
    }

    public User getUserByLogin(String login){
        return userRepository.getUserByName(login);
    }
}
