package by.service;


import by.database.repository.UserRepository;
import by.dto.user_dto.FromUserDtoToBase;
import by.dto.user_dto.UserDto;
import by.mapper.classes.users.DtoToUser;
import lombok.RequiredArgsConstructor;
import by.mapper.classes.users.UserToDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final DtoToUser createUserMapper;
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

    public Long saveUser(FromUserDtoToBase fromUserDtoToBase) {
//        var validationFactory = Validation.buildDefaultValidatorFactory();
//        var validator = validationFactory.getValidator();
//        var validationResult = validator.validate(createUserDto);
//        if(!validationResult.isEmpty()){
//            throw new ConstraintViolationException(validationResult);
//        }
        var user = createUserMapper.mapFrom(fromUserDtoToBase);
        var result = userRepository.save(user);
        return result.getId();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public void deleteByPassword(String password){
       var user = userRepository.findByPassword(password).get();
       userRepository.deleteById(user.getId());
    }

    public Optional<UserDto> findById(Long id){
        return userRepository.findById(id).map(userToDto::mapFrom);
    }
}
