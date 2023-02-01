package service.Impl;

import model.User;
import repository.IUserRepository;
import repository.Impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public boolean insertUser(User user) {
        return userRepository.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> searchUser(String country) {
        return userRepository.searchUser(country);
    }
}
