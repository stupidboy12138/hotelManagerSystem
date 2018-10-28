package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Room;
import com.example.demo.domain.User;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import com.example.demo.vo.Parm;
import com.example.demo.vo.ResultVO;
import com.example.demo.vo.RoomInfoVO;
import com.example.demo.vo.RoomVO;
import com.example.demo.vo.SuccessVO;

@Controller
public class RoomController {
	
	@Autowired private RoomService roomService;
	
	@Autowired private RoomRepository roomRepository;
	
	@Autowired private RoomInfoVO roomInfoVO;
	
	@Autowired private ResultVO resultVO;
	
	@Autowired private BuildingRepository buildingRepository;
	
	@Autowired private SuccessVO successVO;
	
	@Autowired private RoomVO roomVO;
	
	private User user = new User();
	private Room room = new Room();
	@GetMapping("roominfo")
	@ResponseBody
	public List<Room> queryRoom(HttpServletRequest request){
		
//		String buildingId = request.getParameter("buildingId");
//		return roomService.roomMessage(buildingId);
		System.out.println(roomRepository.count());
		System.out.println(roomRepository.findAll().iterator());
		return roomRepository.findAll();
		
	}
	
	@GetMapping("allroom")
	public String allRoomInfo(@RequestParam("buildingId") String buildingId,HttpSession session) {
		System.out.println("楼号："+buildingId);
		session.setAttribute("buildingId", buildingId);
		return "rooms";
	}
	
	@PostMapping("buildingroom")
	@ResponseBody
	public ResultVO buildingRoom(HttpSession session,@RequestBody Parm p) {
		String id = p.getId();
		Integer limit = p.getLimit();
		Integer offset = p.getOffset();
		String buildingId = (String) session.getAttribute("buildingId");
		if(id=="") {
		resultVO.setRows(roomRepository.queryRoomInfo(buildingId, offset, limit));
		resultVO.setTotal(roomRepository.totalnumber());
		return resultVO;
		}
		else {
			resultVO.setRows(roomRepository.queryRoomInfoById(id, offset, limit));
			resultVO.setTotal(roomRepository.queryRoomNumberById(id));
			return resultVO;
		}
	}
	
	@GetMapping("queryroom")
	@ResponseBody
	public ResultVO allBuilding(HttpSession session,@RequestBody Parm p) {
		String id = p.getId();
		Integer limit = p.getLimit();
		Integer offset = p.getOffset();
		String buildingId = (String) session.getAttribute("buildingId");
		resultVO.setRows(roomRepository.queryRoomInfoById(id, offset, limit));
		resultVO.setTotal(roomRepository.queryRoomNumberById(id));
		return resultVO;
	}
	
	@PostMapping("modifyroom")
	@ResponseBody
	public SuccessVO modifyRoom(@RequestBody RoomVO roomVO) {
		String roomId = roomVO.getRoomId();
		String buildingId = roomVO.getBuildingId();
		String description = room.getDescription();
		room.setRoomId(roomId);
		room.setBuildingId(buildingId);
		room.setDescription(description);
		roomRepository.save(room);
		return successVO;
	}
	
//	@GetMapping("checkin")
//	public void checkIn(HttpServletRequest request) {
//		room.setRoomid(request.getParameter("roomid"));
//		room.setUsername(request.getParameter("username"));
//		room.setIdcard(request.getParameter("idcard"));
//		room.setTelephone(request.getParameter("telephone"));
//		room.setCheckInTime(request.getParameter("checkintime"));
//		room.setCheckOutTime(request.getParameter("checkouttime"));
//		roomService.checkIn();
//	}
}
