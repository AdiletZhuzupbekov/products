package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.model.dto.CategoryDto;
import kg.megacom.products.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends CrudMapper<Category, CategoryDto> {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
