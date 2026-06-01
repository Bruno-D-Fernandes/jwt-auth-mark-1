package edu.jwt_auth_mark_1.repositories;

import edu.jwt_auth_mark_1.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
