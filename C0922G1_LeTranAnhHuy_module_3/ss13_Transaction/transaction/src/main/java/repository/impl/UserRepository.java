package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String FIND_ALL = "select* from users order by `name`;";
    private static final String INSERT_INTO = "insert into users(`name`, email, country) values(?, ?, ?)";
    private static final String DELETE_USER = "call delete_user(?)";
    private static final String UPDATE_USERS_SQL = "call update_user(?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SEARCH_USERS_BY_COUNTRY = "select * from users where country like ?;";

    @Override
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean insertUser(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(UPDATE_USERS_SQL);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.setInt(4, user.getId());

            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_USER);
            callableStatement.setInt(1, id);
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public User selectUser(int id) {
        Connection connection = BaseRepository.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> searchUser(String countryUser) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_COUNTRY);
            preparedStatement.setString(1, countryUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public String addUserTransaction(User user) {
        String msg = "OK, transaction successfully!";
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                connection.commit();
            } else {
                msg = "rollback try";
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
