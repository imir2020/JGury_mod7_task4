package by.mapper.classes.employees;


import by.database.entity.Employee;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import by.mapper.map_interfaces.employee.DtoToEmployeeMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DtoToEmployee {

    public Employee mapFrom(FromEmployeeDtoToBase employeesDto) {
        return DtoToEmployeeMapper.INSTANCE.fromDto(employeesDto);
    }
}
