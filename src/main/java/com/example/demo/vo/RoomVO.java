package com.example.demo.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RoomVO {
	
	private String roomId;
	
	private String description;
	
	private String buildingId;
	
}
