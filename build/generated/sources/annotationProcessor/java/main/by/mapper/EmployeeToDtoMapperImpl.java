package by.mapper;

import by.database.entity.Employees;
import by.dto.EmployeesDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T17:04:06+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class EmployeeToDtoMapperImpl implements EmployeeToDtoMapper {

    @Override
    public EmployeesDto employeesToDto(Employees employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeesDto.EmployeesDtoBuilder employeesDto = EmployeesDto.builder();

        employeesDto.id( employee.getId() );
        employeesDto.lastName( employee.getLastName() );
        employeesDto.name( employee.getName() );
        employeesDto.middleName( employee.getMiddleName() );
        employeesDto.dateBirth( employee.getDateBirth() );
        employeesDto.phoneNumber( employee.getPhoneNumber() );
        employeesDto.address( employee.getAddress() );

        return employeesDto.build();
    }
}
