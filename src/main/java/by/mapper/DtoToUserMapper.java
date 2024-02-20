package by.mapper;

import by.database.entity.User;
import by.dto.CreateUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToUserMapper {
    DtoToUserMapper INSTANCE = Mappers.getMapper(DtoToUserMapper.class);

    User dtoToUser(CreateUserDto userDto);
}
