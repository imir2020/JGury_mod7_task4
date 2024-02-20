package by.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FromEmployeeDtoToBase {
    String lastName;
    String name;
    String middleName;
    String dateBirth;
    String phoneNumber;
    String address;
    Long rankId;
}
