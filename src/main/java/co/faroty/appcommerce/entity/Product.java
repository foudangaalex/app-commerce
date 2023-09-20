package co.faroty.appcommerce.entity;

import co.faroty.appcommerce.security.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long prodId;
    @Column(length = 25)
   private String designation;
   private double price;
    @Column(length = 25)
   private String image;
   private boolean isValid;
   @ManyToOne
   private Users users;
    @ManyToOne
   private Category category;
}
