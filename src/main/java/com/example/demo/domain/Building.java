package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Building {
	@Id
	private String BuildingId;
	
	private String address;
	
	private String coding;
	
	private Integer restNumber;
	
	private String floorNumber;
	@JsonIgnore
	private String createTime;
	
	private String name;
	
	private String optid;
	
	private String remark;
}
