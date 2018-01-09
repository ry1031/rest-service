package org.demo;

public class RegisterResult {
	
	private final String type;
	private final String content;
	
	public RegisterResult(String type, String content) {
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}
	
}
