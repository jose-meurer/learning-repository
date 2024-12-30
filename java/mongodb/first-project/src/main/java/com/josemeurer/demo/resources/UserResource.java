package com.josemeurer.demo.resources;

import com.josemeurer.demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Green", "maria@gmail,com");
        User alex = new User("2", "Alex Brown", "alex@gmail.com");
        List<User> list = Arrays.asList(maria, alex);
        return ResponseEntity.ok().body(list);
    }
}
