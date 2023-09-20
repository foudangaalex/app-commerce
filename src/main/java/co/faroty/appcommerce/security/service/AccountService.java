package co.faroty.appcommerce.security.service;

import co.faroty.appcommerce.dtos.UserDTO;
import co.faroty.appcommerce.security.entity.Role;
import co.faroty.appcommerce.security.entity.Users;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
//    void deleteUser(String id);

    void deleteUser(Long id);

    List<UserDTO> findAllUsers();
    Optional<UserDTO> findUsersById(Long id);
    Users loadUserByUserName(String userName);
    Role addNewRole(String role);
    void addRoleToUser(String role,String userName);
    void removeRoleFromUser(String role,String userName);

}
