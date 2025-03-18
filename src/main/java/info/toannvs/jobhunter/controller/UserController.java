package info.toannvs.jobhunter.controller;

import info.toannvs.jobhunter.domain.User;
import info.toannvs.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
