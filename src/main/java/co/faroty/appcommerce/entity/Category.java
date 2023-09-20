package co.faroty.appcommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    @Column(length = 25)
    private String nameCat;
    @ManyToOne
    private Admin admin;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> product;
}
