package kg.megacom.products.service;

import kg.megacom.products.model.dto.DiscountDto;
import kg.megacom.products.model.entity.Product;
import kg.megacom.products.model.requests.ProductRequest;

public interface DiscountService {
    DiscountDto save(ProductRequest productRequest, Product product);
}
