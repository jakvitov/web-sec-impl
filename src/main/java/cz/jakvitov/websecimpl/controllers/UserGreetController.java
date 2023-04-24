package cz.jakvitov.websecimpl.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test controllers to set up security with
 */
@RestController
public class UserGreetController {

    @GetMapping("/greet")
    public String greetEveryone(){
        return "Hello";
    }

    @GetMapping("/user/greet")
    public String greetUser(){
        return "Hello user";
    }

    @GetMapping("/admin/greet")
    public String greetAdmin(){
        return "Hello admin";
    }

}
