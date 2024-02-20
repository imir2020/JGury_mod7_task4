package by.database.repository;

import by.database.entity.Employees;
import by.database.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findAllBy();

    Optional<Products> findById(Long id);

    Products save(Products product);

//    @Modifying
//    @Query("""
//            update Products p
//            set p =: product
//            where p.id =: id
//            """)
 //   void updateProductById(Products product, Long id);

    void deleteById(Long id);
}
