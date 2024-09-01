package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import java.util.List;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arUsers = this.userService.getAllUserByEmail("hoanglongvippro3@gmail.com");
        System.out.println(arUsers);
        model.addAttribute("LongLee", "test");
        model.addAttribute("hoilongle", "form controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user") // GET
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        return "/admin/user/table-user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createtUserPage(Model model, @ModelAttribute("newUser") User hoilongle) {
        this.userService.handleSaveUser(hoilongle);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.GET)
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }

}

// @RestController
// public class UserController {
// //DI: dependency injection
// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }