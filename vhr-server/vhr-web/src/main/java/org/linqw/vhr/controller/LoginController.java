package org.linqw.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "尚未登陆，请登陆!";
    }
}
