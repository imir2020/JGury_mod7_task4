package by.database.repository;

import by.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders,Long> {

    List<Orders> findAllBy();

    Optional<Orders> findById(Long id);

    Orders save(Orders order);
//
//    @Modifying
//    @Query("""
//            update Orders o
//            set o =: order
//            where o.id =:id
//            """)
//    void  updateOrderByName(Orders order, Long id);

    void deleteById(Long id);
}
