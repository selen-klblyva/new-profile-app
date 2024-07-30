package az.edu.turing.newprofileapp.controller;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.entity.UserEntity;
import az.edu.turing.newprofileapp.exception.UserNotFoundException;
import az.edu.turing.newprofileapp.service.UserService;
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


    @GetMapping("/all")
    public List<UserDto> getAllProfile() {
        log.info("Get all profiles:\"GET -> /api/v1/profile\"");
        return userService.getAllProfiles();
    }

    @GetMapping
    public Long getCountOfAllUsers() {
        return userService.getAllProfiles().stream().count();
    }


    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        log.info("Get profile by id: \"{}\"",id);
        return userService.getProfileById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUserById(@PathVariable Long id, @RequestBody UserEntity userEntity) throws UserNotFoundException {
        log.info("Update user by id request received: {}", id);
        return userService.update(id, userEntity);
    }


    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        log.info("Create user request received: {}", userDto);
        userService.save(userDto);
    }

    @PatchMapping("/age/{id}")
    public UserEntity updateUserAge(@PathVariable Long id, @RequestBody UserEntity userEntity) throws UserNotFoundException {
        log.info("Update user age by id request received: {}", id);
        return userService.updateAge(id, userEntity);
    }

    @DeleteMapping("/all")
    public void deleteAllProfiles(@PathVariable long id){
        log.info("Delete all profile: \"{}\"",id);
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteProfileById(@PathVariable long id){
        log.info("Delete profile by id: \"{}\"",id);
        userService.deleteById(id);
    }




}
