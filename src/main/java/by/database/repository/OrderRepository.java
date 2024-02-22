package by.database.repository;

import by.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllBy();

    Optional<Order> findById(Long id);

    Order save(Order order);
//
//    @Modifying
//    @Query("""
//            update Orders o
//            set o =: order
//            where o.id =:id
//            """)
//    void  update(Orders order, Long id);

    void deleteById(Long id);
}
