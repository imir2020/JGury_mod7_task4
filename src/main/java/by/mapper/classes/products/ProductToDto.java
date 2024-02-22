package by.mapper.classes.products;


import by.database.entity.Product;
import by.dto.product_dto.ProductDto;
import by.mapper.map_interfaces.product.ProductToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProductToDto {

    public ProductDto mapFrom(Product product){
        return ProductToDtoMapper.INSTANCE.mapFrom(product);
    }
}
