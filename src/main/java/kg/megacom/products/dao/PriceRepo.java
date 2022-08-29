package kg.megacom.products.dao;

import kg.megacom.products.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    public Price findByProductId(Long id);
}
