package by.database.repository;

import by.database.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales,Long > {
   List<Sales> findAllBy();

   Optional<Sales> findById(Long id);

   Sales save(Sales sale);
//
//    @Modifying
//    @Query("""
//            update Sales s
//            set s =: sale
//            where s.id =: id
//            """)
//    void update(Sales sale, Long id);

    void deleteById(Long id);
}
