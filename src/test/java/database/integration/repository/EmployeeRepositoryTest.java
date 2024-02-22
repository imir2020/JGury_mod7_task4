package database.integration.repository;


import annotation.IT;
import by.database.entity.Employee;
import by.database.entity.Rank;
import by.database.repository.EmployeeRepository;
import by.database.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
public class EmployeeRepositoryTest {
    Logger log = LoggerFactory.getLogger(EmployeeRepositoryTest.class);

    private final EmployeeRepository employeesRepository;
    private final RankRepository ranksRepository;


    @Test
    public void findAll() {
        List<Employee> employees = employeesRepository.findAllBy();
        assertTrue(employees.size() > 0);
        employees.forEach(System.out::println);

        log.info("Result list from method findAll(): {}", employees);
    }

    @Test
    public void findById() {
        Long id = 6L;
        Optional<Employee> employee = employeesRepository.findById(id);
        assertTrue(employee.isPresent());
        log.info("Object employees from method findById(): {}", employee.get());
    }

    @Test
    public void save() {
        Long id = 2L;
        Rank rank = ranksRepository.findById(id).get();
        Employee employee = Employee.builder()
                .lastName("Artamonov")
                .name("Alex")
                .middleName("Sadyikov")
                .dateBirth(LocalDate.parse("1980-03-29"))
                .phoneNumber("8-654-333-98-11")
                .address("Torsk, veteranov 54,dom 45,corp 11, kv 67")
                .build();
        employee.setRanks(rank);
        employeesRepository.save(employee);
        log.info("Object from method save() is saved: {}", employee);
    }

    @Test
    public void update() {
//        Long id = 8L;
//        Employee employee = employeesRepository.findById(id).get();
//        employee.setPhoneNumber("8-992-555-10-00");
//        employee.setName("Leonid");
//
//        employeesRepository.update(employee, id);
//        Employee getEmployee = employeesRepository.findById(id).get();
//        assertEquals(employee, getEmployee);
//        log.info("Object from method update() is updated: {}", employee);
    }

    @Test
    public void delete() {
        Long id = 11L;
        employeesRepository.deleteById(id);
        Optional<Employee> employee = employeesRepository.findById(id);
        assertTrue(employee.isEmpty());

        log.warn("Object was deleted in method delete()");
    }

    /**
     * Вывести всех работников без учёта менеджеров.
     * Отсортировать по дню рождения
     */
    @Test
    public void findAllEmployeesLessManagers() {
//        List<Employees> list = employeesRepository.findAllEmployeesLessManagers();
//        list.forEach(System.out::println);
//        assertThat(list).hasSize(7);
    }

    /**
     * Найти телефон работника по id
     */
    @Test
    public void findEmployeesPhoneNumberById() {
//        Long employeeId = 2L;
//
//        String phoneNumber = employeesRepository.findEmployeesPhoneNumberById(employeeId);
//        assertEquals("8-925-444-89-17", phoneNumber);
//        System.out.println(phoneNumber);
    }

    @Test
    public void changeEmployeeStatus() {
//        Long employeeId = 6L;
//        Employees employee = employeesRepository.changeEmployeeStatus(employeeId, Greid.MANAGER);
//        Employees employeeFromBase = employeesRepository.findById(employeeId).get();
//        assertEquals(employee.getRank().getRankName(), employeeFromBase.getRank().getRankName());
    }
}
