package by.mapper;

import by.database.entity.User;
import by.dto.CreateUserDto;

public class DtoToUser {
    private static final DtoToUser INSTANCE = new DtoToUser();

    public User mapFrom(CreateUserDto userDto) {
        return DtoToUserMapper.INSTANCE.dtoToUser(userDto);
    }

    public static DtoToUser getInstance() {
        return INSTANCE;
    }
}
