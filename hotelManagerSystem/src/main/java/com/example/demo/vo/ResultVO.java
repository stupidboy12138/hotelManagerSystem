package com.example.demo.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResultVO<T> {
	
	private Integer total;
	
	private T rows;
	
}
