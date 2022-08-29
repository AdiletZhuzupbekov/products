package kg.megacom.products.service;

import kg.megacom.products.model.dto.PriceDto;
import kg.megacom.products.model.entity.Product;
import kg.megacom.products.model.requests.ProductRequest;

public interface PriceService {
    PriceDto save(ProductRequest productRequest, Product product);
}
