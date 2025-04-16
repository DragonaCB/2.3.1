package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl {
    private static int UserID;
    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++UserID, "Tom", "tom@gmail.com"));
        users.add(new User(++UserID, "Jane", "jane@gmail.com"));
        users.add(new User(++UserID, "Jack", "jack@gmail.com"));
        users.add(new User(++UserID, "Bob", "bob@gmail.com"));
        users.add(new User(++UserID, "David", "david@gmail.com"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++UserID);
        users.add(user);
    }

    public void update(int id, User updateUser) {
        User updateToUpdate = show(id);
        updateToUpdate.setName(updateUser.getName());
        updateToUpdate.setEmail(updateUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
