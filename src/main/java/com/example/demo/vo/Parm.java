package com.example.demo.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Parm {
	
	private String id;
	
	private Integer limit;
	
	private Integer offset;
	
}
