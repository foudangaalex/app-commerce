package co.faroty.appcommerce.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @Column(length = 25)
    private String role;
}
