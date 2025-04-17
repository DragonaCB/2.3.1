package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements web.dao.UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }

    @Transactional
    public void updateUser(int id, User updateUser) {
        User updateToUpdate = em.find(User.class, id);
        if (updateToUpdate != null) {
            updateToUpdate.setName(updateUser.getName());
            updateToUpdate.setEmail(updateUser.getEmail());
            em.merge(updateToUpdate);
        }
    }

    @Transactional
    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
}
