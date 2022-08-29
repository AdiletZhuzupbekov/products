package kg.megacom.products.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    private Long id;
    private String title;
    private CategoryDto category;
}
