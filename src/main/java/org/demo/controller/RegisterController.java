package org.demo.controller;

import org.demo.model.RegisterResult;
import org.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(tags = "Registration API")
@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public RegisterResult register(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "location") String location) {
		return registerService.register(userId, location);
	}
}