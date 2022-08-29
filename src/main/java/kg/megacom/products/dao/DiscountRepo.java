package kg.megacom.products.dao;

import kg.megacom.products.model.entity.Discount;
import kg.megacom.products.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Long> {

    Discount findByProductId(Long id);
}
