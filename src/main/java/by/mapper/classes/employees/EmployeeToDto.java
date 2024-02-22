package by.mapper.classes.employees;

import by.database.entity.Employee;
import by.dto.employees_dto.EmployeeDto;
import by.mapper.map_interfaces.employee.EmployeeToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public class EmployeeToDto {

    public EmployeeDto mapFrom(Employee employee) {
        return EmployeeToDtoMapper.INSTANCE.employeesToDto(employee);
    }

}
