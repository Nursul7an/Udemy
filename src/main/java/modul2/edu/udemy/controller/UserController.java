package modul2.edu.udemy.controller;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
