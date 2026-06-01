package edu.jwt_auth_mark_1.domain.product;

import edu.jwt_auth_mark_1.repositories.ProductDAO;

public record ProductResponseDTO(
        Integer id,
        String nomeProduto,
        double valorProduto
){

    public ProductResponseDTO(Product product) {
        this(product.getIdProduto(), product.getNomeProduto(), product.getValorProduto());
    }

}
