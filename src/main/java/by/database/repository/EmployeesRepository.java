package by.database.repository;

import by.database.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    List<Employees> findAllBy();

    Optional<Employees> findById(Long id);

    Employees save(Employees employee);

    @Modifying
    @Query("""
            update Employees e 
            set e =: employee
            where e.id =: id
            """)
    void update(Employees employee, Long id);

    void deleteById(Long id);

//    @Query("""
//            select e from Employees e
//            where not e.rank.id =: 2
//            order by e.dateBirth
//            """)
//    List<Employees> findAllEmployeesLessManagers();

//    @Query("""
//            select e.phoneNumber from Employees e
//            where e.id = :id
//            """)
//    String findEmployeesPhoneNumberById(Long employeeId);
//    @Modifying
//    @Query(" update Employees e " +
//           " set e.rank.rankName = :status " +
//           " where e.id =: employeeId ")
//    Employees changeEmployeeStatus(Long employeeId, Greid status);

}

