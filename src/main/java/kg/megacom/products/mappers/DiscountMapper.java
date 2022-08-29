package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.model.dto.DiscountDto;
import kg.megacom.products.model.entity.Discount;
import kg.megacom.products.model.requests.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper extends CrudMapper<Discount, DiscountDto> {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount productRequestToDiscount(ProductRequest productRequest);
}
