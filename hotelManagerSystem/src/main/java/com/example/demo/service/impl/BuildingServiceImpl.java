package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Building;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.service.BuildingService;


@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<Building> queryBuilding() {
		return buildingRepository.findAll();
	}
	@Override
	public List<Building> findBuildInfo(Integer limit, Integer offset, String Id, String address) {
		return null;
	}
	@Override
	public List<Building> firstBuildingInfo(Integer limit, Integer offset) {
		return null;
	}
	
}
