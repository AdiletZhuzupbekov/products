package kg.megacom.products.service;

import kg.megacom.products.model.dto.CategoryDto;
import kg.megacom.products.model.entity.Category;

public interface CategoryService {
    CategoryDto saveCategory(CategoryDto categoryDto);

    boolean existsById(Long id);

    void checkExistsByIdAndActive(Long id);

    Category findById(Long id);
}
