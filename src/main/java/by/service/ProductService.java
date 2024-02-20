package by.service;

import by.database.repository.ProductsRepository;
import by.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productsRepository ;

    public ProductDto findById(Long id) {
        return productsRepository.findById(id).map(products ->
                new ProductDto(products.getId(),
                        ("%s-%s").formatted(
                                products.getName(),
                                String.valueOf(products.getCount())
                        ))).get();

    }
}
