package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Building;

public interface BuildingService {
	
	public List<Building> queryBuilding();
	
	public List<Building> findBuildInfo(Integer limit,Integer offset,String Id,String address);
	
	public List<Building> firstBuildingInfo(Integer limit,Integer offset);
}
