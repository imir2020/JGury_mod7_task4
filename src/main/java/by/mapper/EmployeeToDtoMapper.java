package by.mapper;

import by.database.entity.Employees;
import by.dto.EmployeesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeToDtoMapper {
    EmployeeToDtoMapper INSTANCE = Mappers.getMapper(EmployeeToDtoMapper.class);

    EmployeesDto employeesToDto(Employees employee);
}
