package com.stage24.review_spring_boot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/* @RestController simplifies RESTful service development by combining @Controller and
    @ResponseBody in one annotation */
@RestController
public class FirstController {

    //@GetMapping("/hello")
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

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord orderRecord) {
        return "Hello Post for: " + orderRecord.toString();
    }

    /* this how it looks like:
     * http://localhost:8081/hello/mohamedlhb */
    @GetMapping("/hello/{name}")
    public String pathVariable(@PathVariable String name) {
        return "Hello " + name;
    }

    // if you want to run this url "/hello" you should comment the first
    // url in the line 9
    /* this how it looks like:
    * http://localhost:8081/hello?fname=med&lname=lhb */
    @GetMapping("/hello")
    public String reqVariable(@RequestParam String fname, @RequestParam String lname) {
        return "Hello " + fname + lname;
    }

/*    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello 2 Everyone";
    }   */


}
