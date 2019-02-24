package com.example.springrestdoc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
public class MemberController {

    @GetMapping(value = "/{id}")
    public String getMember(@PathVariable Long id) {


        return "{id:1}";
    }
}
