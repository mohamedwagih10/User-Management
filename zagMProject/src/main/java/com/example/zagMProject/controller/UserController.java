package com.example.zagMProject.controller;


import com.example.zagMProject.model.User;
import com.example.zagMProject.service.UserService;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService1){
        this.userService = userService1;
    }
    @GetMapping("/User/{id}")
    public ResponseEntity<User> data(@PathVariable @Valid int id){
        User user =userService.GetUserDetails(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/Users")
    public ResponseEntity<List<User>> details(){
        List<User> users=userService.GetAllUsers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody @Valid  User user){
         userService.Create(user);
         return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

@PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable @Valid int id , @RequestBody @Valid User user){
        userService.Update(user,id);
       return ResponseEntity.ok("User is updated");
}
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable @Valid  int id){
        userService.Delete(id);
        return ResponseEntity.ok("is deleted");
}

@GetMapping("/flitering")
    public ResponseEntity<List<User>> filter(@RequestParam @Valid String status, @RequestParam @Valid String role){
        List<User> users=userService.Filter(status,role);
      return ResponseEntity.ok(users);
}
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handelarBlindException(BindException ex){
        return new ResponseEntity<>(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
