package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepository;
	@Override
	public List<Room> roomMessage(String buildingId) {
		return roomRepository.findByBuildingId(buildingId);
	}
	
	@Override
	public void checkIn(Room room) {
		roomRepository.save(room);
	}

	@Override
	public void modifyIsIn(String roomId) {
		roomRepository.updateIsIn(roomId);
	}
	
}
