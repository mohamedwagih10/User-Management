package com.example.zagMProject.controller;


import com.example.zagMProject.model.User;
import com.example.zagMProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService1){
        this.userService = userService1;
    }

    @GetMapping(path = "/get/ID/{userId}")
    public User getUserDetails(@PathVariable Integer userId){
        return new User(1, "emanmohamed", "1234", "eman@gmail.com", "Eman Mohamed",
                "01234", "Admin", "Female", "Active");
    }






//    private List<User> users = new ArrayList<>();
//
//    @PostMapping(path = "/adduser")
//    public void createUser(@RequestBody User user){
//        users.add(user);
//    }
//
//    @DeleteMapping(path = "/delete/username/{userName}")
//    public String deleteUserDetails(String userName){
//        this.users = null;
//        return "Deleted successfully";
//    }
}
