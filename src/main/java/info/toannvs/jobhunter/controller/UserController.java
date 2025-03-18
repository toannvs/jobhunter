package info.toannvs.jobhunter.controller;

import info.toannvs.jobhunter.domain.User;
import info.toannvs.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/create")
    public User createNewUser(@RequestBody User user) {
        return userService.handleCreateUser(user);
    }
}
