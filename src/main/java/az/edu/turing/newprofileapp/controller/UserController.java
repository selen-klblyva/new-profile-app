package az.edu.turing.newprofileapp.controller;

import az.edu.turing.newprofileapp.dto.UserDto;
import az.edu.turing.newprofileapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserController {


    private final UserService userService;


    @GetMapping
    public List<UserDto> getAllProfile() {
        log.info("Get all profiles:\"GET -> /api/v1/profile\"");
        return userService.getAllProfiles();
    }

    @GetMapping
    public Long getCountOfAllUsers() {
        return userService.getAllProfiles().stream().count();
    }


    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id) {
        log.info("Get profile by id: \"{}\"",id);
        return userService.getProfileById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(
            @PathVariable Long id,
            @RequestParam String username,
            @RequestParam int age) {
        userService.updateProfile(id, username, age);
    }

    @PostMapping
    public UserDto create_Profile(@RequestBody UserDto userDto) {
        log.info("Create profile: \"{}\"",userDto);
        return userService.createProfile(userDto);
    }

    @DeleteMapping("/{id}")
    public long deleteProfileById(@PathVariable long id){
        log.info("Delete profile by id: \"{}\"",id);
        return userService.deleteById(id);
    }

    @DeleteMapping("/{id}")
    public long delete_AllProfiles(@PathVariable long id){
        log.info("Delete profile by id: \"{}\"",id);
        return userService.deleteAllProfiles(id);
    }




}
