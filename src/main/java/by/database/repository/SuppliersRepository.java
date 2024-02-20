package by.database.repository;

import by.database.entity.Suppliers;
import lombok.Cleanup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {

    List<Suppliers> findAllBy();

    Optional<Suppliers> findById(Long id);

    Suppliers save(Suppliers supplier);


//    @Modifying
//    @Query("""
//            update Suppliers s
//            set s =: supplier
//            where s.id =:id
//            """)
//    void update(Suppliers supplier, Long id);

    void deleteById(Long id);

    /**
     * Найти и вывести отсортированный список всех телефонных номеров
     */
    @Query("""
            select s.phoneNumber from Suppliers s 
            order by s.phoneNumber
            """)
    List<String> listPhoneNumbers();

    /**
     * Вывести все отсортированные email и телефонные номера
     */
    @Query("""
            select s.email,s.phoneNumber from Suppliers s
            order by s.email asc
            """)
    List<Object[]> listEmailAndPhoneNumber();
}
