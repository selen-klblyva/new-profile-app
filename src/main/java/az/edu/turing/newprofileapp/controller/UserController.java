package az.edu.turing.newprofileapp.controller;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserController {
    private final UserService userService;


    @GetMapping
    public List<UserDto> getAllUser() {
        log.info("Get all users:\"GET -> /api/v1/profile\"");
        return userService.getAllUsers();
    }

    @GetMapping
    public int getCountOfAllUsers() {
        log.info("Get all profiles:\"GET -> /api/v1/profile\"");
        return userService.getCountOfAllProfiles();
    }


    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id) {
        log.info("Get user by id: \"{}\"",id);
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto update_User(@PathVariable long id,@RequestBody UserDto userDto) {
        log.info("Update user by id: \"{}\"",id);
        return userService.updateUser(userDto);
    }

    @PostMapping
    public UserDto create_User(@RequestBody UserDto userDto) {
        log.info("Create user: \"{}\"",userDto);
        return userService.createUser(userDto);
    }

    @DeleteMapping("/{id}")
    public long deleteUserById(@PathVariable long id){
        log.info("Delete user by id: \"{}\"",id);
        return userService.deleteById(id);
    }

    @DeleteMapping("/{id}")
    public long deleteAllUsers(@PathVariable long id){
        log.info("Delete user by id: \"{}\"",id);
        return userService.deleteAllProfiles(id);
    }


}
