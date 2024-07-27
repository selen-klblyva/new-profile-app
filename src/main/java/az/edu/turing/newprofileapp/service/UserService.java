package az.edu.turing.newprofileapp.service;

import az.edu.turing.newprofileapp.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUsers();

    UserDto getUserById(long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    public long deleteById(long id);

    public int getCountOfAllProfiles();

    public long deleteAllProfiles(long id);


}
