package info.toannvs.jobhunter.controller;

import info.toannvs.jobhunter.domain.User;
import info.toannvs.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.handleGetUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.handleGetAllUsers();
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User user) {
        return userService.handleCreateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.handleDeleteUser(id);
    }
}
