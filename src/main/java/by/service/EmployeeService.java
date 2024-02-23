package by.service;


import by.database.repository.EmployeeRepository;
import by.dto.employees_dto.EmployeeDto;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import by.mapper.classes.employees.DtoToEmployee;
import by.mapper.classes.employees.EmployeeToDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeesRepository;
    private final EmployeeToDto employeeToDto;
    private final DtoToEmployee dtoToEmployee;


    public List<EmployeeDto> findAll() {
        log.info("Attempt to extract EmployeeDto collection in method findAll()");
        return employeesRepository.findAll().stream().map(employeeToDto::mapFrom)
                .collect(Collectors.toList());

    }

    public Optional<EmployeeDto> findById(Long id) {
        log.info("Attempt to extract EmployeeDto object in method findById()");
        return employeesRepository.findById(id).map(employeeToDto::mapFrom);

    }

    public void save(FromEmployeeDtoToBase toBaseEmployeeDto) {
        var user = dtoToEmployee.mapFrom(toBaseEmployeeDto);
        var result = employeesRepository.save(user);
        log.info("Attempt to save toBaseEmployeeDto object in method save()");
    }

    public void updateAddress(String address, Long id) {
        employeesRepository.updateAddress(address, id);
        log.info("Attempt to update address in Employee object by your id, in method updateAddress()");


    }

    public void delete(Long id) {
        employeesRepository.deleteById(id);
        log.info("Attempt to delete Employee object in method delete()");
    }

    public Optional<String> findPhoneNumberById(Long id) {
        var employee = employeesRepository.findPhoneNumberById(id);
        return Optional.ofNullable(employee);

    }
}
