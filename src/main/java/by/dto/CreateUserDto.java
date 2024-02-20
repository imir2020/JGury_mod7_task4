package by.dto;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String password;
    String status;
}
