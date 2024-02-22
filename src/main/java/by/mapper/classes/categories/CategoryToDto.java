package by.mapper.classes.categories;


import by.database.entity.Category;
import by.dto.category_dto.CategoryDto;
import by.mapper.map_interfaces.category.CategoryToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CategoryToDto {

    public CategoryDto mapFrom(Category category){
        return CategoryToDtoMapper.INSTANCE.fromCategory(category);
    }
}
