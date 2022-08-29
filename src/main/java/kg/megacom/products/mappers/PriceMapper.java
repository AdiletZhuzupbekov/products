package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.model.dto.PriceDto;
import kg.megacom.products.model.entity.Price;
import kg.megacom.products.model.requests.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends CrudMapper<Price, PriceDto> {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price productRequestToPrice(ProductRequest productRequest);

}
