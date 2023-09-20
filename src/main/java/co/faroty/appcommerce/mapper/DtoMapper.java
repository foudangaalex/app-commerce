package co.faroty.appcommerce.mapper;

import co.faroty.appcommerce.dtos.CategoryDTO;
import co.faroty.appcommerce.dtos.ProductDTO;
import co.faroty.appcommerce.dtos.UserDTO;
import co.faroty.appcommerce.entity.Category;
import co.faroty.appcommerce.entity.Product;
import co.faroty.appcommerce.security.entity.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper {
   // @Bean
    public UserDTO fromUsersDTO(Users users){
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(users,userDTO);
        return userDTO;
    }

    //@Bean
    public Users fromUsers(UserDTO userDTO){
        Users users=new Users();
        BeanUtils.copyProperties(userDTO,users);
        return users;
    }

    public CategoryDTO fromCategoryDTO(Category category){
        CategoryDTO categoryDTO=new CategoryDTO();
        BeanUtils.copyProperties(category,categoryDTO);
        return categoryDTO;
    };
    public Category fromCategory(CategoryDTO categoryDTO){
        Category category=new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        return category;
    };

    public ProductDTO fromProductDTO(Product product){
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        productDTO.setUserDTO(fromUsersDTO(product.getUsers()));
        //productDTO.setCategoryDTO(fromCategoryDTO(product.getCategory()));
        return productDTO;
    }

    public Product fromProduct(ProductDTO productDTO){
        Product product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setUsers(fromUsers(productDTO.getUserDTO()));
       // product.setCategory(fromCategory(productDTO.getCategoryDTO()));
        return product;
    }


}
