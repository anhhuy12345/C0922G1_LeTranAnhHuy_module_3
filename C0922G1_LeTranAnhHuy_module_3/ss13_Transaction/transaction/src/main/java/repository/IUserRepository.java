package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAllUser();

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    User selectUser(int id);

    List<User> searchUser(String country);

    String addUserTransaction(User user);
}
