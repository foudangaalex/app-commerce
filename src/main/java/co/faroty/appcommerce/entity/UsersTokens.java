package co.faroty.appcommerce.entity;

import co.faroty.appcommerce.security.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class UsersTokens {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    @Column(length = 64)
    private String token;
    @OneToOne
    private Users users;
}
