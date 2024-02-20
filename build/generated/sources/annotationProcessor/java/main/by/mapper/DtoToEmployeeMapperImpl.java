package by.mapper;

import by.database.entity.Employees;
import by.dto.FromEmployeeDtoToBase;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T17:04:06+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class DtoToEmployeeMapperImpl implements DtoToEmployeeMapper {

    @Override
    public Employees fromDto(FromEmployeeDtoToBase employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employees.EmployeesBuilder employees = Employees.builder();

        employees.lastName( employeeDto.getLastName() );
        employees.name( employeeDto.getName() );
        employees.middleName( employeeDto.getMiddleName() );
        if ( employeeDto.getDateBirth() != null ) {
            employees.dateBirth( LocalDate.parse( employeeDto.getDateBirth() ) );
        }
        employees.phoneNumber( employeeDto.getPhoneNumber() );
        employees.address( employeeDto.getAddress() );

        return employees.build();
    }
}
