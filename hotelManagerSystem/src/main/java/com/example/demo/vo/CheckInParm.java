package com.example.demo.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class CheckInParm {

	private String bookRoomID;
	
	private String userID;
	
	private String userPhone;
	
	private Date bookIn;
	
	private Date bookOut;
	
}
