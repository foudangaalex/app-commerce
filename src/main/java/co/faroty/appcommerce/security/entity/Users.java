package co.faroty.appcommerce.security.entity;

import co.faroty.appcommerce.entity.Product;
import co.faroty.appcommerce.entity.UsersTokens;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 25,unique = true)
    private String userName;
    @Column(length = 25)
    private String email;
    @Column(length = 25)
    private String imageUser;
    @Column(length = 25)
    private String tel;
    private String passWord;
    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    private List<Product> productList;
    @OneToOne(mappedBy = "users")
    private UsersTokens usersTokens;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}
