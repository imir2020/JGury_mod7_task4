package by.dto;

import by.database.entity.Status;
import lombok.Builder;
import lombok.Value;
import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Long id;
    String name;
    LocalDate birthday;
    Status status;
}
