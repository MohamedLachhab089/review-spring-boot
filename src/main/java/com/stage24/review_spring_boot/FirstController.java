package com.stage24.review_spring_boot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Everyone";
    }

    @PostMapping("/post")
    public String post(@RequestBody String msg) {
        return "Hello Post for: " + msg;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order) {
        return "Hello Post for: " + order.toString();
    }

/*    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello 2 Everyone";
    }   */


}
