package com.josemeurer.store.resouces;

import com.josemeurer.store.dto.UserIpDto;
import com.josemeurer.store.entities.User;
import com.josemeurer.store.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //Debug
    @GetMapping("/ip")
    public ResponseEntity<UserIpDto> userIp(@RequestHeader Map<String, String> headers) {

        UserIpDto dto = new UserIpDto();
        dto.setRemoteAddr(request.getRemoteAddr());
        dto.setRemotePort(request.getRemotePort());
        dto.setRemoteHost(request.getRemoteHost());

        dto.setLocalAddr(request.getLocalAddr());
        dto.setLocalPort(request.getLocalPort());
        dto.setLocalName(request.getLocalName());

        if (request.getHeader("X_FORWARDED_FOR") == null ){
            dto.setForwarded(request.getHeader("x-forwarded-for"));
        }else {
            dto.setForwarded(request.getHeader("X_FORWARDED_FOR"));
        }

        dto.setHeaders(headers);

        return ResponseEntity.ok().body(dto);
    }
}
