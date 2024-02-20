package database.integration.repository;

import annotation.IT;
import by.database.entity.Employees;
import by.database.entity.Products;
import by.database.entity.Sales;
import by.database.repository.EmployeesRepository;
import by.database.repository.ProductsRepository;
import by.database.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
public class SalesRepositoryTest {

    private final SalesRepository salesRepository;
    private final ProductsRepository productsRepository;
    private final EmployeesRepository employeesRepository;


    @Test
    public void findAll() {
        List<Sales> list = salesRepository.findAllBy();
        assertTrue(list.size() > 0);
        list.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Long id = 1L;
        Optional<Sales> sales = salesRepository.findById(id);
        assertTrue(sales.isPresent());
    }

    @Test
    public void save() {
        Long employeeId = 4L;
        Long productId = 6L;
        Employees employee = employeesRepository.findById(employeeId).get();
        Products product = productsRepository.findById(productId).get();
        Sales sales = Sales.builder()
                .product(product)
                .count(4L)
                .employee(employee)
                .dateSales(LocalDate.now())
                .build();
        salesRepository.save(sales);
    }

    @Test
    public void update() {
//        Long id = 1L;
//        Sales sales = salesRepository.findById(id).get();
//        sales.setCount(15L);
//
//        salesRepository.update(sales,id);
//        Sales beforeUpdate = salesRepository.findById(id).get();
//        assertEquals(sales, beforeUpdate);

    }

    @Test
    public void delete() {
        Long id = 2L;
        salesRepository.deleteById(id);
        Optional<Sales> sale = salesRepository.findById(id);
        assertTrue(sale.isEmpty());
    }
}
