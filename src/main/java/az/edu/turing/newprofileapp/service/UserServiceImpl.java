package az.edu.turing.newprofileapp.service;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.entity.UserEntity;
import az.edu.turing.newprofileapp.exception.UserNotFoundException;
import az.edu.turing.newprofileapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    public void save(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .username(userDto.getUsername())
                .age(userDto.getAge())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        userRepository.save(userEntity);
        log.info("User saved: {}", userEntity);
    }


    public UserEntity update(Long id, UserEntity userEntity) throws UserNotFoundException {
        Optional<UserEntity> foundedUser = userRepository.findById(id);

        if (foundedUser.isPresent()) {
            UserEntity updatedUser = foundedUser.get();
            updatedUser.setUsername(userEntity.getUsername());
            updatedUser.setAge(userEntity.getAge());
            updatedUser.setCreatedAt(LocalDateTime.now());
            updatedUser.setUpdatedAt(LocalDateTime.now());
            userRepository.save(updatedUser);
            log.info("User updated with id: {}", id);
            return updatedUser;
        } else {
            log.warn("User not found with id: {}", id);
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }


    @Override
    public UserEntity updateAge(Long id, UserEntity userEntity) throws UserNotFoundException {
        Optional<UserEntity> foundedUser = userRepository.findById(id);
        if (foundedUser.isPresent()) {
            UserEntity updatedUser = foundedUser.get();
            updatedUser.setAge(userEntity.getAge());
            userRepository.save(updatedUser);
            log.info("User age updated with id: {}", id);
            return updatedUser;
        } else {
            log.warn("User not found with id: {}", id);
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }


    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public int getCountOfAllProfiles() {
        return (int) userRepository.count();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }


}
