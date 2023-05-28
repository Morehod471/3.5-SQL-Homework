import Model.Role;
import Model.RoleType;
import Model.User;
import Service.RoleDAO;
import Service.RoleDAOImpl;
import Service.UserDAO;
import Service.UserDAOImpl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Application {

    static UserDAO userDAO = new UserDAOImpl();
    static RoleDAO roleDAO = new RoleDAOImpl();

    public static void main(String[] args) {

        Role developer = Role.builder().type(RoleType.DEVELOPER).build();
        Role analyst = Role.builder().type(RoleType.ANALYST).build();
        Role tester = Role.builder().type(RoleType.TESTER).build();

        Set<Role> role = new HashSet<>();
        role.add(roleDAO.getById(1));
        User newUser = User.builder()
                .name("John")
                .login("Wall")
                .password("Street")
                .created(LocalDateTime.now())
                .modified(LocalDateTime.now())
                .role(role)
                .build();
        User newUser2 = userDAO.mergeUser(newUser);
        role.add(roleDAO.getById(2));
        newUser2.setRole(role);
        userDAO.mergeUser(newUser2);
    }

}
