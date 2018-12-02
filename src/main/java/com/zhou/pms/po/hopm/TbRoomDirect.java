package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbRoomDirect entity. @author MyEclipse Persistence Tools
 */

public class TbRoomDirect implements java.io.Serializable {

	// Fields

	private Integer roomDirectId;
	private String roomDirectName;
	private Set tbRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbRoomDirect() {
	}

	/** minimal constructor */
	public TbRoomDirect(Integer roomDirectId) {
		this.roomDirectId = roomDirectId;
	}

	/** full constructor */
	public TbRoomDirect(Integer roomDirectId, String roomDirectName, Set tbRooms) {
		this.roomDirectId = roomDirectId;
		this.roomDirectName = roomDirectName;
		this.tbRooms = tbRooms;
	}

	// Property accessors

	public Integer getRoomDirectId() {
		return this.roomDirectId;
	}

	public void setRoomDirectId(Integer roomDirectId) {
		this.roomDirectId = roomDirectId;
	}

	public String getRoomDirectName() {
		return this.roomDirectName;
	}

	public void setRoomDirectName(String roomDirectName) {
		this.roomDirectName = roomDirectName;
	}

	public Set getTbRooms() {
		return this.tbRooms;
	}

	public void setTbRooms(Set tbRooms) {
		this.tbRooms = tbRooms;
	}

}