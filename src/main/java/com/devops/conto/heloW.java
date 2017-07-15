package com.devops.conto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XxX on 7/15/2017.
 */
@Controller
public class heloW {

    @RequestMapping("/")
    public String sayHello(){
        return "index";
    }
}
