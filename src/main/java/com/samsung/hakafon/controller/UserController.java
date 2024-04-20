package com.samsung.hakafon.controller;

import com.samsung.hakafon.domain.User;
import com.samsung.hakafon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User getDyId(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/user/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @GetMapping("/user/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
