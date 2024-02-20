package by.service;


import by.database.repository.UserRepository;
import by.dto.CreateUserDto;
import by.dto.UserDto;
import by.mapper.DtoToUser;
import lombok.RequiredArgsConstructor;
import by.mapper.UserToDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final DtoToUser createUserMapper = DtoToUser.getInstance();
    private final UserToDto userToDto;
    private final UserRepository userRepository;

    public Optional<UserDto> login(String password) {
        Optional<UserDto> result = userRepository.findByPassword(password)
                .map(userToDto::mapFrom);
        if (result.isEmpty()) {
            log.warn("The password is not exist: {}", password);
        } else {
            log.info("The User with name {} was login", result.get().getName());
        }
        return result;
    }

    public Long create(CreateUserDto createUserDto) {
//        var validationFactory = Validation.buildDefaultValidatorFactory();
//        var validator = validationFactory.getValidator();
//        var validationResult = validator.validate(createUserDto);
//        if(!validationResult.isEmpty()){
//            throw new ConstraintViolationException(validationResult);
//        }
        var user = createUserMapper.mapFrom(createUserDto);
        var result = userRepository.save(user);
        return result.getId();
    }
}
