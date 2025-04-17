package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}