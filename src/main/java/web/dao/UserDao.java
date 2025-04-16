package web.dao;

import java.util.List;

import web.models.User;

public interface UserDao {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
