package by.mapper.classes.users;

import by.database.entity.User;
import by.dto.user_dto.FromUserDtoToBase;
import by.mapper.map_interfaces.user.DtoToUserMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public class DtoToUser {

    public User mapFrom(FromUserDtoToBase userDto) {
        return DtoToUserMapper.INSTANCE.mapFrom(userDto);
    }

}
