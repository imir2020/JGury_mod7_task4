package by.database.repository;

import by.database.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale,Long > {
   List<Sale> findAllBy();

   Optional<Sale> findById(Long id);

   Sale save(Sale sale);
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
