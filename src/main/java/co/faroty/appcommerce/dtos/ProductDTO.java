package co.faroty.appcommerce.dtos;


import lombok.Data;

@Data
public class ProductDTO {

    private Long prodId;
    private String designation;
    private double price;
    private String image;
    private boolean isValid;
    private UserDTO userDTO;
   // private CategoryDTO categoryDTO;
}
