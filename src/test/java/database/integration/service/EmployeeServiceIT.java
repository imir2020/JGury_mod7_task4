package database.integration.service;

import annotation.IT;
import by.database.entity.Rank;
import by.database.repository.RankRepository;
import by.dto.employees_dto.EmployeeDto;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import by.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class EmployeeServiceIT {
    private final EmployeeService employeeService;
    private final RankRepository rankRepository;

    @Test
    public void findAll() {
        var actualResultList = employeeService.findAll();
        assertTrue(actualResultList.size() > 0);
        actualResultList.forEach(System.out::println);
    }

    @Test
    public void findById() {
        Long id = 2L;
        var actual = employeeService.findById(id);
        assertTrue(actual.isPresent());
    }

    @Test
    public void save() {
        Rank rank = rankRepository.findById(2L).get();
        FromEmployeeDtoToBase employee = FromEmployeeDtoToBase.builder()
                .lastName("Artamonov")
                .name("Alex")
                .middleName("Sadyikov")
                .dateBirth(LocalDate.parse("1980-03-29"))
                .phoneNumber("8-654-333-98-11")
                .address("Torsk, veteranov 54,dom 45,corp 11, kv 67")
                .rank(rank)
                .build();
        employeeService.save(employee);
    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {
        Long id = 1L;
        employeeService.delete(id);
    }
}