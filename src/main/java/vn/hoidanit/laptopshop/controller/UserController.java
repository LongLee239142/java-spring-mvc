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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User users = this.userService.getOneById(id);
        // System.out.println("Check path id = " + id);
        // System.out.println("Check path email = " + users.getEmail());
        model.addAttribute("id", id);
        model.addAttribute("user", users);
        return "/admin/user/show";
    }

    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.GET)
    public String getUpdateUser(Model model, @PathVariable long id) {
        User currentUser = this.userService.getOneById(id);
        model.addAttribute("updateUser", currentUser);
        return "/admin/user/update";
        // return "admin/user/delete";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("updateUser") User hoilongle) {
        User currentUser = this.userService.getOneById(hoilongle.getId());
        if (currentUser != null) {
            currentUser.setAddress(hoilongle.getAddress());
            currentUser.setFullName(hoilongle.getFullName());
            currentUser.setPhoneNumber(hoilongle.getPhoneNumber());

            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getOneById(id);
        model.addAttribute("deleteUser", user);
        model.addAttribute("id", id);
        return "admin/user/delete";
    }

    @PostMapping("admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("deleteUser") User hoilongle) {
        System.out.println("Run here");
        this.userService.deleteAUser(hoilongle.getId());
        return "redirect:/admin/user";
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