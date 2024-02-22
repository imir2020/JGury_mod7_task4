package by.database.repository;

import by.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllBy();

    Optional<Product> findById(Long id);

    Product save(Product product);

//    @Modifying
//    @Query("""
//            update Products p
//            set p =: product
//            where p.id =: id
//            """)
 //   void updateProductById(Products product, Long id);

    void deleteById(Long id);
}
