package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Room;

public interface RoomService {
	
	public List<Room> roomMessage(String buildingId);
	
	public void checkIn(Room room);
	
	public void modifyIsIn(String roomId);
	
}
