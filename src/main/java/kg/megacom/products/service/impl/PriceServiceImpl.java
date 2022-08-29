package kg.megacom.products.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.products.dao.PriceRepo;
import kg.megacom.products.mappers.PriceMapper;
import kg.megacom.products.model.dto.PriceDto;
import kg.megacom.products.model.entity.Price;
import kg.megacom.products.model.entity.Product;
import kg.megacom.products.model.requests.ProductRequest;
import kg.megacom.products.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepo priceRepo;
    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
        this.priceMapper = PriceMapper.INSTANCE;
    }

    @Override
    public PriceDto save(ProductRequest productRequest, Product product) {

        Price price = priceMapper.productRequestToPrice(productRequest);


            price.setStartDate(new Date());
            price.setEndDate(new Date());
            price.setProduct(product);
            priceRepo.save(price);





        return priceMapper.toDto(price);
    }
}
