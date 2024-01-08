package com.gr.bksafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 24/12/2023
 * @Time: 18:31
 */
@RestController
@RequestMapping("/requests")
public class RequestController {
    @RequestMapping()
    public String index() {
        return "Hello world";
    }
}
