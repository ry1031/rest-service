package org.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @RequestMapping("/register")
    public RegisterResult greeting(@RequestParam(value="userId") String userId, 
    		@RequestParam(value="location") String location) {
        return new RegisterResult("text", "success");
    }
}
