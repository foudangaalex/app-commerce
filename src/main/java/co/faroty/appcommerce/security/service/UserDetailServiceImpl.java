package co.faroty.appcommerce.security.service;

import co.faroty.appcommerce.security.entity.Users;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users= accountService.loadUserByUserName(username);
        if(users==null) throw new UsernameNotFoundException("this username %s not founds"+username);
         String[] roles=users.getRoles().stream().map(u->u.getRole()).toArray(String[]::new);
        UserDetails userDetails= User
                .withUsername(username)
                .password(users.getPassWord())
                .roles(roles)
                .build();
        return userDetails;
    }
}
