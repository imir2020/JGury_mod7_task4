package by.mapper;

import by.database.entity.User;
import by.dto.UserDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;


@Component
@NoArgsConstructor
public class UserToDto {

    public UserDto mapFrom(User object) {
        return UserToDtoMapper.INSTANCE.toDto(object);
    }
}
