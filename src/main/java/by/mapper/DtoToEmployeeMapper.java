package by.mapper;

import by.database.entity.Employees;
import by.dto.FromEmployeeDtoToBase;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToEmployeeMapper {
    DtoToEmployeeMapper INSTANCE = Mappers.getMapper(DtoToEmployeeMapper.class);

    Employees fromDto(FromEmployeeDtoToBase employeeDto);
}
