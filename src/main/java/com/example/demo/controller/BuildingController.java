package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Building;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.service.BuildingService;
import com.example.demo.vo.BuildingVO;
import com.example.demo.vo.Parm;
import com.example.demo.vo.ResultVO;
import com.example.demo.vo.SuccessVO;

@RestController
public class BuildingController {
	
	@Autowired private BuildingService buildingService;
	
	@Autowired private BuildingRepository buildingRepository;
	
	@Autowired private ResultVO resultVO;
	
	@Autowired private SuccessVO successVO;
	
			   private Building building = new Building();
	
	@PostMapping("buildinginfo")
	@ResponseBody
	public ResultVO buildingInfo(@RequestBody Parm p,HttpServletRequest request){
		Integer limit = p.getLimit();
		Integer offset = p.getOffset();
		String id = p.getId();
		if(id=="") {
		System.out.println(buildingRepository.firstBuildingInfo(offset, limit));
		resultVO.setRows(buildingRepository.firstBuildingInfo(offset, limit));
		resultVO.setTotal(buildingRepository.totalnumber());
		return resultVO;
		}
		else {
			resultVO.setRows(buildingRepository.findBuildInfo(id, offset, limit));
			resultVO.setTotal(buildingRepository.queryBuildingnumber(id));
			return resultVO;
		}
		
	}
	
	@PostMapping("querybuildinginfo")
	@ResponseBody
	public ResultVO querybuildingInfo(HttpServletRequest request,@RequestBody Parm p) {
		String id = p.getId();
		Integer limit = p.getLimit();
		Integer offset = p.getOffset();
		System.out.println(buildingRepository.findBuildInfo(id, offset, limit));
		resultVO.setRows(buildingRepository.findBuildInfo(id, offset, limit));
		resultVO.setTotal(buildingRepository.queryBuildingnumber(id));
		return resultVO;
	}
	@PostMapping("addbuilding")
	@ResponseBody
	public SuccessVO addBuilding(@RequestBody BuildingVO buildingVO) {
		String buildingId = buildingVO.getBuildingId();
		String address = buildingVO.getAddress();
		building.setBuildingId(buildingId);
		building.setAddress(address);
		buildingRepository.save(building);
		return successVO;
	}
	@PostMapping("delbuilding")
	@ResponseBody
	public SuccessVO delbuilding(@RequestBody BuildingVO buildingVO) {
		String buildingId = buildingVO.getBuildingId();
		buildingRepository.deleteById(buildingId);
		return successVO;
	}
}
