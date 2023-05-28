package Service;

import Model.Role;
import Model.User;

import java.util.List;

public interface UserDAO {

    User mergeUser(User user);

    User getById(int id);

    List<User> getAllUser();

    void deleteUser(User user);

    void addRoleToUser(User user, Role role);
}
