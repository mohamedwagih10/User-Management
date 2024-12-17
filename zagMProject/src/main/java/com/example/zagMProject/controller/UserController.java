package com.example.zagMProject.controller;


import com.example.zagMProject.model.User;
import com.example.zagMProject.service.UserService;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService1){
        this.userService = userService1;
    }
    @GetMapping("/User/{id}")
    public User data(@PathVariable int id){
        return userService.GetUserDetails(id);
    }
    @GetMapping("/Users")
    public List<User> details(){
        return userService.GetAllUsers();
    }
    @PostMapping("/add")
    public void create(@RequestBody User user){
         userService.Create(user);
    }

@PutMapping("/update/{id}")
    public void update(@PathVariable int id , @RequestBody  User user){
        userService.Update(user,id);
}
@DeleteMapping("/delate/{userFullName}")
    public void delete(@PathVariable String userFullName){
        userService.Delete(userFullName);
}

@GetMapping("/flitering")
    public List<User> filter(@RequestParam String status, @RequestParam String role){
      return   userService.Filter(status,role);
}




/*
    @GetMapping(path = "/get/ID/{userId}")
    public User getUserDetails(@PathVariable Integer userId){
        return new User(1, "emanmohamed", "1234", "eman@gmail.com", "Eman Mohamed",
                "01234", "Admin", "Female", "Active");
    }*/






//    private List<User> users = new ArrayList<>();
//
 //   @PostMapping(path = "/adderse")
 //   public void createUser(@Valid @RequestBody User user){
//        users.add(user);
//    }
//
//    @DeleteMapping(path = "/delete/username/{userName}")
//    public String deleteUserDetails(String userName){
//        this.users = null;
//        return "Deleted successfully";
//    }
}
