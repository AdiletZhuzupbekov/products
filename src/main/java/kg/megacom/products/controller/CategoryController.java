package kg.megacom.products.controller;

import kg.megacom.products.model.dto.CategoryDto;
import kg.megacom.products.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        return  categoryService.saveCategory(categoryDto);
    }
}
