package by.mapper.map_interfaces.employee;

import by.database.entity.Employee;
import by.dto.employees_dto.FromEmployeeDtoToBase;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T13:33:59+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.8 (Oracle Corporation)"
)
public class DtoToEmployeeMapperImpl implements DtoToEmployeeMapper {

    @Override
    public Employee fromDto(FromEmployeeDtoToBase employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.lastName( employeeDto.getLastName() );
        employee.name( employeeDto.getName() );
        employee.middleName( employeeDto.getMiddleName() );
        employee.dateBirth( employeeDto.getDateBirth() );
        employee.phoneNumber( employeeDto.getPhoneNumber() );
        employee.address( employeeDto.getAddress() );
        employee.rank( employeeDto.getRank() );

        return employee.build();
    }
}
