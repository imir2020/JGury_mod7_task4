package by.service;

import by.database.entity.Product;
import by.database.repository.ProductRepository;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import by.dto.product_dto.FromProductDtoToBase;
import by.dto.product_dto.ProductDto;
import by.mapper.classes.products.DtoToProduct;
import by.mapper.classes.products.ProductToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productsRepository;
    private final ProductToDto productToDto;
    private final DtoToProduct dtoToProduct;

    public List<ProductDto> findAll() {
        return productsRepository.findAll()
                .stream()
                .map(productToDto::mapFrom)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(Long id) {
        return productsRepository.findById(id).map(productToDto::mapFrom);
    }

    public void save(FromProductDtoToBase fromProductDtoToBase) {
        var product = dtoToProduct.mapFrom(fromProductDtoToBase);
        productsRepository.save(product);
    }

    public void update(FromProductDtoToBase fromProductDtoToBase) {

    }

    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}
