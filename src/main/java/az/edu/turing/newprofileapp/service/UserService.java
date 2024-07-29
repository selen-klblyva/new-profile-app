package az.edu.turing.newprofileapp.service;

import az.edu.turing.newprofileapp.dto.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    public List<UserDto> getAllProfiles();

    UserDto getProfileById(long id);

    public UserDto createProfile(UserDto userDto);

    void updateProfile(Long id,String username,int age);

    public long deleteById(long id);

    public int getCountOfAllProfiles();

    public long deleteAllProfiles(long id);

}
