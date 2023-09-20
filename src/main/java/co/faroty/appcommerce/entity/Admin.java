package co.faroty.appcommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @Column(length = 25)
    private String name;
    private String password;
    @OneToMany(mappedBy = "admin",fetch = FetchType.LAZY)
    private List<Category> category;
}
