package co.faroty.appcommerce.security.service;

import co.faroty.appcommerce.dtos.UserDTO;
import co.faroty.appcommerce.security.entity.Role;
import co.faroty.appcommerce.security.entity.Users;
import co.faroty.appcommerce.mapper.DtoMapper;
import co.faroty.appcommerce.security.repo.RoleRepository;
import co.faroty.appcommerce.security.repo.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private UsersRepository usersRepository;
    private DtoMapper dtoMapper;
    private RoleRepository roleRepository;
    @Override
    public UserDTO addUser(UserDTO userDTO) {
        Users users=dtoMapper.fromUsers(userDTO);
        Users users1 = usersRepository.save(users);
        return dtoMapper.fromUsersDTO(users1);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        Users users=dtoMapper.fromUsers(userDTO);
        Users users1 = usersRepository.save(users);
        return dtoMapper.fromUsersDTO(users1);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }


    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> userDTOList = usersRepository.findAll().stream().map(users -> dtoMapper.fromUsersDTO(users)).collect(Collectors.toList());
        return userDTOList;
    }

    @Override
    public Optional<UserDTO> findUsersById(Long id) {
        return usersRepository.findById(id).map(users -> dtoMapper.fromUsersDTO(users));
    }

    @Override
    public Users loadUserByUserName(String userName) {
        return  usersRepository.findByUserName(userName);
    }

    @Override
    public Role addNewRole(String role) {
        Role r=roleRepository.findById(role).orElse(null);
        if (r!=null) throw new RuntimeException("This role already exist");
        Role r2=new Role();
        r2.setRole(role);
        return roleRepository.save(r2);
    }

    @Override
    public void addRoleToUser(String role, String userName) {
        Users user=usersRepository.findByUserName(userName);
        Role role1=roleRepository.findById(role).get();
        user.getRoles().add(role1);
    }

    @Override
    public void removeRoleFromUser(String role, String userName) {
        Users user=usersRepository.findByUserName(userName);
        Role role1=roleRepository.findById(role).get();
        user.getRoles().remove(role1);
    }
}
