package by.mapper;

import by.database.entity.Employees;
import by.dto.EmployeesDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public class EmployeeToDto {

    public EmployeesDto mapFrom(Employees employee) {
        return EmployeeToDtoMapper.INSTANCE.employeesToDto(employee);
    }

}
