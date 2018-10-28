package com.example.demo.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CheckLockVO {
	
	private Integer code;
	
	private boolean canlock;
	
	private Date intime;
	
	private Date outtime;
	
}
