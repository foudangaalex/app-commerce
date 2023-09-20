package co.faroty.appcommerce.web;

import co.faroty.appcommerce.dtos.ProductDTO;
import co.faroty.appcommerce.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductContrllerAPI {

    private ProductService productService;

    @GetMapping("/products")
    List<ProductDTO> findAlProducts(){
        return productService.findAlProducts();
    }

    @GetMapping("/products/{id}")
    void deleteProduct(@PathVariable(name = "id") Long productId) {
        productService.deleteProduct(productId);
    }

    }

