package com.example.demo.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class LoginSuccessVO {
	
	private Integer code;
	
	private String token;
	
}
