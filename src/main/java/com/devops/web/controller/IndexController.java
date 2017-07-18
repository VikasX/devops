package com.devops.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XxX on 7/18/2017.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
