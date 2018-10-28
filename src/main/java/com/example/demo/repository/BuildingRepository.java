package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Building;

public interface BuildingRepository extends JpaRepository<Building, String>{
	
	//根据楼栋ID查询楼栋信息
	@Query(value = "SELECT * FROM BUILDING WHERE BUILDING_ID=?1 LIMIT ?2,?3",
//			QueryCount = "SELECT count(*) FROM BUILDING",
			nativeQuery = true)
		List<Building> findBuildInfo(String Id,Integer limit,Integer offset);
	//根据楼栋ID查询楼栋数
	@Query(value = "SELECT count(*) FROM BUILDING WHERE BUILDING_ID=?",
			nativeQuery = true)
		Integer queryBuildingnumber(String buildingId);
	//查询所有楼栋信息
	@Query(value = "SELECT * FROM BUILDING LIMIT ?1,?2",
		    nativeQuery = true)
	List<Building> firstBuildingInfo(Integer limit,Integer offset);
	//查询总楼栋数
	@Query(value = "SELECT count(*) FROM BUILDING",
			nativeQuery = true)
		Integer totalnumber();
}
