package kg.megacom.products.service.impl;

import kg.megacom.products.dao.DiscountRepo;
import kg.megacom.products.mappers.DiscountMapper;
import kg.megacom.products.model.dto.DiscountDto;
import kg.megacom.products.model.entity.Discount;
import kg.megacom.products.model.entity.Product;
import kg.megacom.products.model.requests.ProductRequest;
import kg.megacom.products.service.DiscountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountMapper discountMapper;
    private final DiscountRepo discountRepo;

    public DiscountServiceImpl(DiscountRepo discountRepo) {
        this.discountRepo = discountRepo;
        this.discountMapper = DiscountMapper.INSTANCE;
    }

    @Override
    public DiscountDto save(ProductRequest productRequest, Product product) {

        Discount discount = discountMapper.productRequestToDiscount(productRequest);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, productRequest.getDiscountDuration());
            discount.setStartDate(new Date());
            discount.setEndDate(cal.getTime());
            discount.setProduct(product);

       discountRepo.save(discount);

        return discountMapper.toDto(discount);
    }
}