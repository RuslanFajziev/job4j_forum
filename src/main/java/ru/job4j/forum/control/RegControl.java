package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.model.User;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService userService;
    private final AuthorityService authorityService;

    public RegControl(PasswordEncoder encoder, UserService userService, AuthorityService authorityService) {
        this.encoder = encoder;
        this.userService = userService;
        this.authorityService = authorityService;
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessage = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, int authorityId, Model model) {
        String userName = user.getUsername();
        if (userService.checkUser(user)) {
            String errorMessage = "There is already a user with this var, try another NAME!!".replace("var", userName);
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        } else {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(authorityService.findById(authorityId));
            userService.save(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/reg")
    public String regPage(Model model) {
        model.addAttribute("authorities", authorityService.getAllAuthority());
        return "reg";
    }
}