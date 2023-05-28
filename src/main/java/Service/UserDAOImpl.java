package Service;

import Model.Role;
import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User mergeUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public User getById(int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> getAllUser() {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void deleteUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(user);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User newUser = entityManager.find(User.class, user.getId());
        Role addedRole = entityManager.find(Role.class, role.getId());
        newUser.getRole().add(addedRole);
        transaction.commit();
        entityManager.close();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("myPersistanceUnit");
        return entityManager.createEntityManager();
    }
}
