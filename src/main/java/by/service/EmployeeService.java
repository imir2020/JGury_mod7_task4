package by.service;


import by.database.repository.EmployeeRepository;
import by.dto.employees_dto.EmployeeDto;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import by.mapper.classes.employees.DtoToEmployee;
import by.mapper.classes.employees.EmployeeToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeesRepository;
    private final EmployeeToDto employeeToDto;
    private final DtoToEmployee dtoToEmployee;


    public List<EmployeeDto> findAll() {
        return employeesRepository.findAll().stream().map(employeeToDto::mapFrom)
                .collect(Collectors.toList());

    }

    public Optional<EmployeeDto> findById(Long id) {
        return employeesRepository.findById(id).map(employeeToDto::mapFrom);

    }

    public void save(FromEmployeeDtoToBase toBaseEmployeeDto) {
        var user = dtoToEmployee.mapFrom(toBaseEmployeeDto);
        var result = employeesRepository.save(user);
    }

    public void update(EmployeeDto employeeDto){

    }

    public void delete(Long id){
        employeesRepository.deleteById(id);
    }
}
