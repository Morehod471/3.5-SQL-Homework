package Service;

import Model.Role;

import javax.persistence.*;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {


    @Override
    public Role mergeRole(Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(role);

        transaction.commit();
        entityManager.close();
        return role;
    }


    @Override
    public Role getById(int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.find(Role.class,id);
    }

    @Override
    public List<Role> getAllRoles() {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.createQuery("FROM Role").getResultList();
    }

    @Override
    public void deleteRole(Role role) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(role);

        transaction.commit();
        entityManager.close();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("myPersistanceUnit");
        return entityManager.createEntityManager();
    }
}
