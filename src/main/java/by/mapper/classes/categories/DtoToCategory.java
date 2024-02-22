package by.mapper.classes.categories;


import by.database.entity.Category;
import by.dto.category_dto.FromCategoryDtoToCategory;
import by.mapper.map_interfaces.category.DtoToCategoryMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DtoToCategory {

    public Category mapFrom(FromCategoryDtoToCategory fromCategoryDtoToCategory){
        return DtoToCategoryMapper.INSTANCE.fromDto(fromCategoryDtoToCategory);
    }
}
