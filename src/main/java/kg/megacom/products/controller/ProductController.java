package kg.megacom.products.controller;

import kg.megacom.products.model.requests.ProductRequest;
import kg.megacom.products.model.responce.ProductResponse;
import kg.megacom.products.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
        return productService.addProduct(productRequest);
    }
}
