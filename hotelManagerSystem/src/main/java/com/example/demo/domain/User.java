package com.example.demo.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
//	@NotEmpty(message="用户名不能为空")
//	@Size(min=2, max=20)
//	@JsonIgnore
	private String username;
	
//	@NotEmpty(message="密码不能为空")
//	@Size(min=2, max=20)
//	@JsonIgnore
	private String password;
	
	private String telephone;
	
	private String roomid;
	
	private Date checkInTime;
	
	private Date checkOutTime;
	
	private String idcard;
	


}
