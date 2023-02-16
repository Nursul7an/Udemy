package modul2.edu.udemy.controller;

import lombok.RequiredArgsConstructor;
import modul2.edu.udemy.model.dto.UserDto;
import modul2.edu.udemy.model.dto.request.PasswordRequest;
import modul2.edu.udemy.model.dto.request.RegisterRequest;
import modul2.edu.udemy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
    @PostMapping("/reset/password")
    public ResponseEntity<?> sendLink(@RequestParam String email){
        userService.sendLinkForReset(email);
        return ResponseEntity.ok("Link was sent for this " + email +" email address");
    }
    @PostMapping("/reset/password/{link}")
    public ResponseEntity<?> resetPassword(@PathVariable(name = "link") String link,
                                           @RequestBody PasswordRequest passwordRequest){
        userService.resetPassword(link, passwordRequest);
        return ResponseEntity.ok("The password successfully reset .");
    }
}
