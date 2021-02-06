package ensa.pay.service;

import ensa.pay.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(name="user-service",url="http://ensaspay-zuul-gateway.herokuapp.com/oauth/api/user")
//@Service
public interface OauthService {


    @PostMapping("/create")
    public User createUser(@RequestBody User user);

    @GetMapping("/get/{tel}")
    public User findUserByLogin(@PathVariable String tel);

     @GetMapping("/getAll")
    public List<User> getAll();

}
