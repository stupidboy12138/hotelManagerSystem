package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Building;
import com.example.demo.domain.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	List<Room> findByBuildingId(String buildingId);
	//根据楼栋ID查询该楼栋共有多少房间
	@Query(value = "SELECT * FROM ROOM WHERE BUILDING_ID=?1 LIMIT ?2,?3",
			nativeQuery = true)
		List<Room> queryRoomInfo(String Id,Integer limit,Integer offset);
	//查询所有房间数
	@Query(value = "SELECT count(*) FROM Room",
			nativeQuery = true)
		Integer totalnumber();
	//查询某栋楼的房间数
	@Query(value = "SELECT count(*) FROM ROOM WHERE BUILDING_ID=?1",
			nativeQuery = true)
		Integer querynumber();
	//修改房间状态（是否入住）
	@Query(value = "UPDATE ROOM SET IS_IN=1 WHERE ROOM_ID=?1",
			nativeQuery = true)
	@Modifying
		void updateIsIn(String roomId);
	//根据房间ID查询房间信息
	@Query(value = "SELECT * FROM ROOM WHERE ROOM_ID=?1 LIMIT ?2,?3",
			nativeQuery = true)
		List<Room> queryRoomInfoById(String Id,Integer limit,Integer offset);
	//根据房间ID查询房间数
	@Query(value = "SELECT count(*) FROM ROOM WHERE ROOM_ID=?",
			nativeQuery = true)
		Integer queryRoomNumberById(String roomId);
	
}
