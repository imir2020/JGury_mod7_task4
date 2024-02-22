package by.mapper.classes.products;

import by.database.entity.Product;
import by.dto.product_dto.FromProductDtoToBase;
import by.mapper.map_interfaces.product.DtoToProductMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DtoToProduct {

    public Product mapFrom(FromProductDtoToBase fromProductDtoToBase){
        return DtoToProductMapper.INSTANCE.mapFrom(fromProductDtoToBase);
    }
}
