package database.integration.repository;

import annotation.IT;
import by.database.entity.Orders;
import by.database.entity.Suppliers;
import by.database.repository.OrderRepository;
import by.database.repository.SuppliersRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.utils.HibernateUtil;
import database.utils.TestDataImporter;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@IT
@RequiredArgsConstructor
public class OrdersRepositoryTest {
    Logger log = LoggerFactory.getLogger(OrdersRepositoryTest.class);

    private final OrderRepository orderRepository;
    private final SuppliersRepository suppliersRepository;


    @Test
    public void findAllBy() {
        List<Orders> list = orderRepository.findAllBy();
        assertTrue(list.size() > 0);
        log.info("List of orders is: {}", list);
    }

    @Test
    public void findById() {
        Long orderId = 1L;
        Orders order = orderRepository.findById(orderId).get();
        assertNotNull(order);
        log.info("The order by id is: {}", order);
    }

    @Test
    public void save() {
        Suppliers supplier = Suppliers.builder()
                .name("Tails&&Beaks")
                .address("On the village for grandfather")
                .email("tail@gmail.com")
                .phoneNumber("0-222-999-99-99")
                .build();
        suppliersRepository.save(supplier);
        Orders order = Orders.builder()
                .supplier(supplier)
                .nameProduct("Шоколад")
                .countProduct(2000L)
                .priceProduct(50L)
                .dateOrder(LocalDate.now())
                .build();
        Orders orderAfterSave = orderRepository.save(order);
        assertEquals(order, orderAfterSave);
    }

    @Test
    public void update() {
//        Long orderId = 1L;
//        Orders order = orderRepository.findById(orderId).get();
//        String productName = "chocolate";
//        assertNotNull(order);
//        order.setNameProduct(productName);
//        orderRepository.updateOrderByName(order,orderId);

    }

    @Test
    public void delete() {
        Long orderId = 2L;
        assertThrows(NoSuchElementException.class, () -> {
            orderRepository.deleteById(orderId);
             orderRepository.findById(orderId).get();
        });
    }
}
