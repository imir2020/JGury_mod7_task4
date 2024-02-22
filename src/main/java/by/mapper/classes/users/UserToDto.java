package by.mapper.classes.users;

import by.database.entity.User;
import by.dto.user_dto.UserDto;
import by.mapper.map_interfaces.user.UserToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public class UserToDto {

    public UserDto mapFrom(User object) {
        return UserToDtoMapper.INSTANCE.toDto(object);
    }
}
