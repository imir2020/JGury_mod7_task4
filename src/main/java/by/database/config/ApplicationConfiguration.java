package by.database.config;


import by.database.repository.CategoryRepository;
import by.database.repository.EmployeesRepository;
import by.mapper.DtoToEmployee;
import by.mapper.EmployeeToDto;
import by.service.CategoryService;
import by.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ApplicationConfiguration {
//    @Bean
//    public CategoryService categoryService(CategoryRepository categoryRepository){
//        return new CategoryService(categoryRepository);
//    }
//    @Bean
//    EmployeeService employeeService(EmployeesRepository employeesRepository, EmployeeToDto employeeToDto,
//                                    DtoToEmployee dtoToEmployee){
//        return new EmployeeService(employeesRepository,employeeToDto,dtoToEmployee);
//    }
}
