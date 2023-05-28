package Service;

import Model.Role;

import java.util.List;

public interface RoleDAO {

    Role mergeRole(Role role);

    Role getById(int id);

    List<Role> getAllRoles();

    void deleteRole(Role role);
}
