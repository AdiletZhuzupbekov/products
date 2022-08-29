package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.model.dto.ProductDto;
import kg.megacom.products.model.entity.Product;
import kg.megacom.products.model.requests.ProductRequest;
import kg.megacom.products.model.responce.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper extends CrudMapper<Product, ProductDto> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target ="category.id" )
    ProductDto toProductFromPR(ProductRequest productRequest);
    ProductResponse toProductResponseFromDto(ProductDto productDto);

}
