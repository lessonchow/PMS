package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbRoomFunction entity. @author MyEclipse Persistence Tools
 */

public class TbRoomFunction implements java.io.Serializable {

	// Fields

	private Integer roomFunctionId;
	private String roomFunctionName;
	private Set tbRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbRoomFunction() {
	}

	/** minimal constructor */
	public TbRoomFunction(Integer roomFunctionId) {
		this.roomFunctionId = roomFunctionId;
	}

	/** full constructor */
	public TbRoomFunction(Integer roomFunctionId, String roomFunctionName, Set tbRooms) {
		this.roomFunctionId = roomFunctionId;
		this.roomFunctionName = roomFunctionName;
		this.tbRooms = tbRooms;
	}

	// Property accessors

	public Integer getRoomFunctionId() {
		return this.roomFunctionId;
	}

	public void setRoomFunctionId(Integer roomFunctionId) {
		this.roomFunctionId = roomFunctionId;
	}

	public String getRoomFunctionName() {
		return this.roomFunctionName;
	}

	public void setRoomFunctionName(String roomFunctionName) {
		this.roomFunctionName = roomFunctionName;
	}

	public Set getTbRooms() {
		return this.tbRooms;
	}

	public void setTbRooms(Set tbRooms) {
		this.tbRooms = tbRooms;
	}

}