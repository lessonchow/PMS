package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbRoomType entity. @author MyEclipse Persistence Tools
 */

public class TbRoomType implements java.io.Serializable {

	// Fields

	private Integer roomTypeId;
	private String roomTypeName;
	private Set tbRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbRoomType() {
	}

	/** minimal constructor */
	public TbRoomType(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	/** full constructor */
	public TbRoomType(Integer roomTypeId, String roomTypeName, Set tbRooms) {
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.tbRooms = tbRooms;
	}

	// Property accessors

	public Integer getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return this.roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public Set getTbRooms() {
		return this.tbRooms;
	}

	public void setTbRooms(Set tbRooms) {
		this.tbRooms = tbRooms;
	}

}