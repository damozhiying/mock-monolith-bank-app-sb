package com.kubepay.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kubepay.bank.service.IUserService;

@RestController
public class PingController {

    @Autowired IUserService service;

    @GetMapping("/ping")
    ResponseEntity<String> pong(){
        service.findAll();

        return ResponseEntity.ok().body("pong");
    }

}
