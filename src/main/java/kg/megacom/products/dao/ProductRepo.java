package kg.megacom.products.dao;

import kg.megacom.products.model.dto.ProductDto;
import kg.megacom.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByTitle(String title);
}
