package web.dao;

import java.util.List;

import web.models.User;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
