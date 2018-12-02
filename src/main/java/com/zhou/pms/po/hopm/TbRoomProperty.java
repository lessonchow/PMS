package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbRoomProperty entity. @author MyEclipse Persistence Tools
 */

public class TbRoomProperty implements java.io.Serializable {

	// Fields

	private Integer roomPropertyId;
	private String roomPropertyName;
	private Set tbRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbRoomProperty() {
	}

	/** minimal constructor */
	public TbRoomProperty(Integer roomPropertyId) {
		this.roomPropertyId = roomPropertyId;
	}

	/** full constructor */
	public TbRoomProperty(Integer roomPropertyId, String roomPropertyName, Set tbRooms) {
		this.roomPropertyId = roomPropertyId;
		this.roomPropertyName = roomPropertyName;
		this.tbRooms = tbRooms;
	}

	// Property accessors

	public Integer getRoomPropertyId() {
		return this.roomPropertyId;
	}

	public void setRoomPropertyId(Integer roomPropertyId) {
		this.roomPropertyId = roomPropertyId;
	}

	public String getRoomPropertyName() {
		return this.roomPropertyName;
	}

	public void setRoomPropertyName(String roomPropertyName) {
		this.roomPropertyName = roomPropertyName;
	}

	public Set getTbRooms() {
		return this.tbRooms;
	}

	public void setTbRooms(Set tbRooms) {
		this.tbRooms = tbRooms;
	}

}