package by.mapper;


import by.database.entity.Employees;
import by.dto.FromEmployeeDtoToBase;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DtoToEmployee {

    public Employees mapFrom(FromEmployeeDtoToBase employeesDto) {
        return DtoToEmployeeMapper.INSTANCE.fromDto(employeesDto);
    }
}
