package az.edu.turing.newprofileapp.service;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.entity.UserEntity;
import az.edu.turing.newprofileapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllProfiles() {
        return userRepository.findAll().stream()
                .map(entity-> new UserDto(entity.getId(),entity.getUsername(), entity.getAge(),
                        entity.getCreatedAt(),entity.getUpdatedAt(), entity.getPhotoURL()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getProfileById(long id) {
                UserEntity userEntity = userRepository.getById(id);
                if(userEntity == null){
                    log.error("User not found");
                }

                return new UserDto(userEntity.getId(),userEntity.getUsername(), userEntity.getAge(),
                        userEntity.getCreatedAt(), userEntity.getUpdatedAt(), userEntity.getPhotoURL());
    }

    @Override
    public UserDto createProfile(UserDto userDto) {
        userDto.setCreatedAt(LocalDateTime.now());
        userDto.setUpdatedAt(LocalDateTime.now());

        int rowsAffected = userRepository.createProfile(
                userDto.getUsername(),
                userDto.getAge(),
                userDto.getCreatedAt(),
                userDto.getUpdatedAt()
        );

        if (rowsAffected > 0) {
            return userDto;
        } else {
            throw new RuntimeException("Do not create profile");
        }
    }

    @Override
    public void updateProfile(Long id, String username, int age) {
        userRepository.updateProfile(id, username, age);
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
