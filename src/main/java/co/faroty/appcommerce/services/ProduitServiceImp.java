
package co.faroty.appcommerce.services;

import co.faroty.appcommerce.dtos.ProductDTO;
import co.faroty.appcommerce.entity.Product;
import co.faroty.appcommerce.security.entity.Users;
import co.faroty.appcommerce.mapper.DtoMapper;
import co.faroty.appcommerce.repository.CategoryRepository;
import co.faroty.appcommerce.repository.ProductRepository;
import co.faroty.appcommerce.security.repo.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor

public class ProduitServiceImp implements ProductService {
    private UsersRepository usersRepository;
    private DtoMapper dtoMapper;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;



    @Override
    public ProductDTO saveProduct(String designation, double price, String image, boolean isValid, String user) {
        Users usersByName = usersRepository.findByUserName(user);
        //UserDTO userDTO = dtoMapper.fromUsersDTO(usersByName);
        //other categoryByNane = categoryRepository.findById(categoryId).orElseThrow();
       // CategoryDTO categoryDTO = dtoMapper.fromCategoryDTO(categoryByNane);
        Product product=new Product();
        product.setDesignation(designation);
        product.setImage(image);
        product.setValid(isValid);
        product.setPrice(price);
        product.setUsers(usersByName);
       // product.setCategory(categoryByNane);
        Product save = productRepository.save(product);
        return dtoMapper.fromProductDTO(save);
    }

    @Override
    public ProductDTO updateProduct(String designation, double price, String image, boolean isValid, String user) {
        Users usersByName = usersRepository.findByUserName(user);
        //UserDTO userDTO = dtoMapper.fromUsersDTO(usersByName);
        //other categoryByNane = categoryRepository.findById(categoryId).orElseThrow();
        // CategoryDTO categoryDTO = dtoMapper.fromCategoryDTO(categoryByNane);
        Product product=new Product();
        product.setDesignation(designation);
        product.setImage(image);
        product.setValid(isValid);
        product.setPrice(price);
        product.setUsers(usersByName);
        // product.setCategory(categoryByNane);
        Product save = productRepository.save(product);
        return dtoMapper.fromProductDTO(save);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);

    }

    @Override
    public ProductDTO findProductById(Long id) {
        productRepository.findById(id);
        return null;
    }

    @Override
    public List<ProductDTO> findAlProducts() {
        List<Product> all = productRepository.findAll();
        List<ProductDTO> productDTOS = all.stream().map(product -> dtoMapper.fromProductDTO(product)).collect(Collectors.toList());
        return productDTOS;
    }
}
