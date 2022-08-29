package kg.megacom.products.service.impl;

import kg.megacom.products.dao.ProductRepo;
import kg.megacom.products.mappers.ProductMapper;
import kg.megacom.products.model.dto.DiscountDto;
import kg.megacom.products.model.dto.PriceDto;
import kg.megacom.products.model.dto.ProductDto;
import kg.megacom.products.model.entity.Product;
import kg.megacom.products.model.requests.ProductRequest;
import kg.megacom.products.model.responce.ProductResponse;
import kg.megacom.products.service.CategoryService;
import kg.megacom.products.service.DiscountService;
import kg.megacom.products.service.PriceService;
import kg.megacom.products.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final PriceService priceService;
    private final DiscountService discountService;

    public ProductServiceImpl(ProductRepo productRepo, CategoryService categoryService, PriceService priceService, DiscountService discountService) {
        this.productRepo = productRepo;
        this.categoryService = categoryService;
        this.priceService = priceService;
        this.discountService = discountService;
        this.productMapper = ProductMapper.INSTANCE;
    }

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {

        //map productDto from product request
        ProductDto productDto = productMapper.toProductFromPR(productRequest);

        //map product from dto
        Product product = productMapper.toEntity(productDto);
        if (productRepo.findByTitle(productDto.getTitle())== null ) {
            //check existing in categories and save product
            categoryService.checkExistsByIdAndActive(product.getCategory().getId());
            product = productRepo.save(product);
            //get price and discount dtos from services

        PriceDto priceDto = priceService.save(productRequest, product);
        DiscountDto discountDto = discountService.save(productRequest,product);

        //map product response from dtos
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getId());
        productResponse.setCategoryId(productDto.getCategory().getId());
        productResponse.setTitle(productDto.getTitle());
        productResponse.setPrice(priceDto.getPrice());
        productResponse.setPercent(discountDto.getPercent());
        productResponse.setDiscountEndDate("Скидка до: " + (discountDto.getEndDate()));

        return productResponse;
        } else   throw new RuntimeException("Товар уже сохранен!");
    }
}
