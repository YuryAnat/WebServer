package services;

import models.User;
import repositories.UserRepository;
import repositories.UserRepositoryFactory;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private static UserServiceImpl userService = null;

    private UserServiceImpl(){
        userRepository = new UserRepositoryFactory().getRepository();
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
