package com.example.hellojenkins.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "user";
    }

    @GetMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute UserForm userForm) {
        userRepository.save(new User(userForm.name, userForm.age));

        return "redirect:user";
    }
}
