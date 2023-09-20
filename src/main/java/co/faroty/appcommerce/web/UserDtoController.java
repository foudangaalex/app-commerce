package co.faroty.appcommerce.web;

import co.faroty.appcommerce.dtos.UserDTO;
import co.faroty.appcommerce.security.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class UserDtoController {

    private AccountService accountService;

    @PostMapping("/users")
    public UserDTO saveUsers(@RequestBody  UserDTO userDTO){
        log.info("in saveUsers");
        UserDTO userDTO1 = accountService.addUser(userDTO);
        return userDTO;
    }

    @GetMapping("/users")
    public List<UserDTO> findAllUser(){
        log.info("in findAllUsers");
        List<UserDTO> userDTOList= accountService.findAllUsers();
        return userDTOList;
    }

     @GetMapping("/users/{id}")
    Optional<UserDTO> findUsersById(@PathVariable Long id){
        return accountService.findUsersById(id);
    }


}
