package by.service;

import by.database.repository.CategoryRepository;
import by.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        return categoryRepository.findAllBy().stream().map(category ->
                        new CategoryDto(category.getId(),
                                category.getCategoryName()))
                .collect(Collectors.toList());
    }
}
