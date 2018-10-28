package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Room {
	
	@Id
	private String roomId;
	
	private String buildingId;
	
	private String isIn;
	
	private String description;
	
	private String checkInTime;
	
	private String checkOutTime;
	
	private String idcard;
	
}
