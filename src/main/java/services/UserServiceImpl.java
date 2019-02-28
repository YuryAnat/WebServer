package services;

import factorys.AbstractFactory;
import factorys.Factory;
import models.User;
import repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private static UserService userService = null;

    private UserServiceImpl(){
        AbstractFactory factory = Factory.getFactory();
        userRepository = factory.createUserRepository();
    }

    public static UserService getInstance(){
        if (userService == null){
            return new UserServiceImpl();
        }else {
            return userService;
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
