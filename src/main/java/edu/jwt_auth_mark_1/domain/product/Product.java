package edu.jwt_auth_mark_1.domain.product;


import jakarta.persistence.*;

@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduto;

    @Column(name = "name_product")
    private String nomeProduto;

    @Column(name = "value_product")
    private double valorProduto;

    public Product() {
    }

    public Product(Integer idProduto, String nomeProduto, double valorProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", valorProduto=" + valorProduto +
                '}';
    }

    public Product(ProductRequestDTO productRequestDTO) {
        this.nomeProduto = productRequestDTO.nomeProduto();
        this.valorProduto = productRequestDTO.valorProduto();
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
}
