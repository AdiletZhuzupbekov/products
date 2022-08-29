package kg.megacom.products.service.impl;

import kg.megacom.products.dao.CategoryRepo;
import kg.megacom.products.mappers.CategoryMapper;
import kg.megacom.products.model.dto.CategoryDto;
import kg.megacom.products.model.entity.Category;
import kg.megacom.products.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = CategoryMapper.INSTANCE;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        categoryRepo.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepo.existsById(id);
    }

    @Override
    public void checkExistsByIdAndActive(Long id) {
        Category category = findById(id);

        if (!category.isActive())
            throw new RuntimeException("Категория не активна!");
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Категория не найдена!"));
    }
}
