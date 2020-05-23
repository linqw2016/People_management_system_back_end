package org.linqw.vhr.controller;

import org.linqw.vhr.model.Employee;
import org.linqw.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrService hrService;

    @GetMapping("/hrs")
    public List<Employee> getAllHrs(){
        return hrService.getAllHrsExceptCurrentHr();
    }
}
