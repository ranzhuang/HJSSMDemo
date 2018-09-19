package cn.funnyhuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HJUserController {

    @RequestMapping("/hello")
    public void helloUser() {
        System.out.printf("hello,user");
    }
}
