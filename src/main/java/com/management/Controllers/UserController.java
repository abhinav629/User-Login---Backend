package com.management.Controllers;

import com.management.Model.User;
import com.management.Model.UserModel;
import com.management.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping({"/signup"})
    public ResponseEntity<User> createUser(@RequestBody UserModel user) {
        return new ResponseEntity(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping({"/login"})
    public ResponseEntity<User> checkUser(@RequestBody UserModel user) {
        return new ResponseEntity(this.userService.checkUser(user), HttpStatus.OK);
    }

    @GetMapping({"/details/{userId}"})
    public ResponseEntity<User> getUser(@PathVariable(required = true, name="userId") int userId) {
        return new ResponseEntity(this.userService.getUserDetails(userId), HttpStatus.CREATED);
    }
}