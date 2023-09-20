package co.faroty.appcommerce.services;

import co.faroty.appcommerce.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct( String designation,double price,String image,boolean isValid,String users);
    ProductDTO updateProduct( String designation,double price,String image,boolean isValid,String users);

//    ProductDTO saveProduct(String designation, double price, String image, boolean isValid, Long usersId);
//
//    ProductDTO updateProduct(String designation, double price, String image, boolean isValid, Long usersId);

    void deleteProduct(Long productId);
    ProductDTO findProductById(Long id);
    List<ProductDTO> findAlProducts();

}
