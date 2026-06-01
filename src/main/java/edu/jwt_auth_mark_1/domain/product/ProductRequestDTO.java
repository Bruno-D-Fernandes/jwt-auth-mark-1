package edu.jwt_auth_mark_1.domain.product;

public record ProductRequestDTO(
        String nomeProduto, double valorProduto
) {

    @Override
    public String nomeProduto() {
        return nomeProduto;
    }

    @Override
    public double valorProduto() {
        return valorProduto;
    }

}
