package edu.jwt_auth_mark_1.controller;


import edu.jwt_auth_mark_1.domain.product.Product;
import edu.jwt_auth_mark_1.domain.product.ProductRequestDTO;
import edu.jwt_auth_mark_1.domain.product.ProductResponseDTO;
import edu.jwt_auth_mark_1.repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProduct(){
        return productDAO.findAll().stream().map(ProductResponseDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        Product product = new Product(productRequestDTO);
        productDAO.save(product);

        // ResponseEnitity, pesquisar dps
        return ResponseEntity.ok().build();
    }
}
