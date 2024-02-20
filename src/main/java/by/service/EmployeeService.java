package by.service;


import by.database.repository.EmployeesRepository;
import by.dto.EmployeesDto;
import by.dto.FromEmployeeDtoToBase;
import by.mapper.DtoToEmployee;
import by.mapper.EmployeeToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeesRepository employeesRepository;
    private final EmployeeToDto employeeToDto;
    private final DtoToEmployee dtoToEmployee;


    public List<EmployeesDto> findAll() {
        return employeesRepository.findAll().stream().map(employeeToDto::mapFrom)
                .collect(Collectors.toList());

    }
    public Long saveEmployee(FromEmployeeDtoToBase toBaseEmployeeDto){
//        var validationFactory = EmbeddedLdapProperties.Validation.class;
//        var validator = validationFactory.getValidator();
//        var validationResult = validator.validate(toBaseEmployeeDto);
//        if(!validationResult.isEmpty()){
//            throw new ConstraintViolationException(validationResult);
//        }
        var user = dtoToEmployee.mapFrom(toBaseEmployeeDto);
        var result = employeesRepository.save(user);
        return result.getId();
    }
}
