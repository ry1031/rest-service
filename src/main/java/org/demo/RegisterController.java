package org.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;

    @RequestMapping("/register")
    public RegisterResult register(@RequestParam(value="userId") String userId, 
    		@RequestParam(value="location") String location) {
        return registerService.register(userId, location);
    }
}

