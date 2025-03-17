package info.toannvs.jobhunter.controller;

import info.toannvs.jobhunter.domain.User;
import info.toannvs.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String createNewUser() {

        User user = new User();
        user.setEmail("toannguyenvosong@gmail.com");
        user.setName("Toàn");
        user.setPassword("toan123456");

        this.userService.handleCreateUser(user);

        return "Create user";
    }
}
