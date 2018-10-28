package com.example.demo.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Component
public class RoomInfoVO {
	
	@JsonProperty("roomid")
	private String roomid;
	
	@JsonProperty("buildingid")
	private String buildingId;
	
	@JsonProperty("isin")
	private Integer isIn;
	
	@JsonProperty("description")
	private String description;
	
}
