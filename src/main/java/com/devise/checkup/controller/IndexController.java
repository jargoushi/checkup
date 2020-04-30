package com.devise.checkup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/20
 * @Content:
 */
@Controller
@CrossOrigin
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "index";
    }
}
