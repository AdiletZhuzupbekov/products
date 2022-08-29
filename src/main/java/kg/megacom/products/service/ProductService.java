package kg.megacom.products.service;

import kg.megacom.products.model.requests.ProductRequest;
import kg.megacom.products.model.responce.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);
}
