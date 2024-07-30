package az.edu.turing.newprofileapp.service;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.entity.UserEntity;
import az.edu.turing.newprofileapp.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllProfiles();

    void save(UserDto userDto);

    UserDto getProfileById(long id);

    void deleteAll();

    void deleteById(long id);

    UserEntity update(Long id, UserEntity userEntity) throws UserNotFoundException;

    UserEntity updateAge(Long id, UserEntity userEntity) throws UserNotFoundException;

    public int getCountOfAllProfiles();


}
