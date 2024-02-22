package by.service;

import by.database.repository.CategoryRepository;
import by.dto.category_dto.CategoryDto;
import by.dto.category_dto.FromCategoryDtoToCategory;
import by.mapper.classes.categories.CategoryToDto;
import by.mapper.classes.categories.DtoToCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final DtoToCategory dtoToCategory;
    private final CategoryToDto categoryToDto;

    public List<CategoryDto> findAll() {
        return categoryRepository.findAllBy()
                .stream()
                .map(categoryToDto::mapFrom)
                .collect(Collectors.toList());


//        .stream().map(category ->CategoryDto.builder()
//                        .category(category.getId())
//                        .categoryName(category.getCategoryName())
//                        .build())
//                .collect(Collectors.toList());
    }

    public Optional<CategoryDto> findById(Long id) {
        return categoryRepository.findById(id).map(category ->CategoryDto.builder()
                .category(category.getId())
                .categoryName(category.getCategoryName())
                        .build());
    }

    public void save(FromCategoryDtoToCategory fromCategoryDtoToCategory) {
        categoryRepository.save(dtoToCategory.mapFrom(fromCategoryDtoToCategory));

    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
