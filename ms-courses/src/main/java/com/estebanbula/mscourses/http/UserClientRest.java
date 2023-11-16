package com.estebanbula.mscourses.http;

import com.estebanbula.mscourses.model.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-users", url = "host.docker.internal:8801/api/users")
public interface UserClientRest {

    @GetMapping("/{id}")
    User userDetail(@PathVariable String id);

    @PostMapping
    User createUser(@RequestBody User user);

    @GetMapping("/users-by-course")
    List<User> listUsers(@RequestParam Iterable<String> ids);

}
