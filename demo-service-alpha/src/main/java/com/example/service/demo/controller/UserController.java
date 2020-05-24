package com.example.service.demo.controller;

import com.example.service.demo.dao.UserRepositoryService;
import com.example.service.demo.model.User;
import com.example.service.demo.model.UserBetaDto;
import com.example.service.demo.restclient.ServiceBetaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private ServiceBetaClient serviceBetaClient;

    @Value("${welcome.message}")
    private String valueFromFile;


    @GetMapping(value="/users")
    public Iterable<User> listUser(){
        logger.info("Get all users interface called.");
        return userRepositoryService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public User getOne(@PathVariable(value = "id") String id){
        logger.info("Get user by id interface called. ID: [{0}]");
        return userRepositoryService.findById(Long.valueOf(id)).orElseThrow(IllegalStateException::new);
    }

    @PostMapping(value="/signup")
    public User saveUser(@RequestBody User user){
        logger.info("Signup interface called. User: [{0}]");
        return userRepositoryService.save(user);
    }

    @GetMapping("/message")
    public String getWelcomemessage() {
        return valueFromFile;
    }

    @GetMapping("/usersBeta")
    public List<UserBetaDto> listBetaUser(){
        logger.info("Get all users from Service Beta called.");
        return serviceBetaClient.getAllStudentsFromServiceBeta();
    }
}
