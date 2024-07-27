package az.edu.turing.newprofileapp.service;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.entity.UserEntity;
import az.edu.turing.newprofileapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(entity-> new UserDto(entity.getId(),entity.getUsername(), entity.getAge(),
                        entity.getCreatedAt(),entity.getUpdatedAt(), entity.getPhotoURL()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
                UserEntity userEntity = userRepository.getById(id);
                if(userEntity == null){
                    log.error("User not found");
                }

                return new UserDto(userEntity.getId(),userEntity.getUsername(), userEntity.getAge(),
                        userEntity.getCreatedAt(), userEntity.getUpdatedAt(), userEntity.getPhotoURL());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto.getId(),userDto.getUsername(),userDto.getAge(),
                userDto.getCreatedAt(),userDto.getUpdatedAt(), userDto.getPhotoURL());
        userRepository.create_User(userEntity);

        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserEntity userEntity=new UserEntity(userDto.getId(),userDto.getUsername(),userDto.getAge(),
                userDto.getCreatedAt(),userDto.getUpdatedAt(), userDto.getPhotoURL());
        userRepository.update_User(userEntity);

        return userDto;
    }

    @Override
    public long deleteById(long id) {
        userRepository.deleteById(id);
        return id;
    }


    @Override
    public int getCountOfAllProfiles() {
        return (int) userRepository.count();
    }

    @Override
    public long deleteAllProfiles(long id) {
        userRepository.deleteAllInBatch();
        return 0;
    }


}
