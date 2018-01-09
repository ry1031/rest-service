package org.demo;

import org.springframework.stereotype.Service;

@Service
public class RegisterService {

	public RegisterResult register(String userId, String location) {
		return new RegisterResult("text", "success");
	}
}
