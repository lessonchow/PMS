package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbRoomDecorate entity. @author MyEclipse Persistence Tools
 */

public class TbRoomDecorate implements java.io.Serializable {

	// Fields

	private Integer roomDecorateId;
	private String roomDecorateName;
	private Set tbRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbRoomDecorate() {
	}

	/** minimal constructor */
	public TbRoomDecorate(Integer roomDecorateId) {
		this.roomDecorateId = roomDecorateId;
	}

	/** full constructor */
	public TbRoomDecorate(Integer roomDecorateId, String roomDecorateName, Set tbRooms) {
		this.roomDecorateId = roomDecorateId;
		this.roomDecorateName = roomDecorateName;
		this.tbRooms = tbRooms;
	}

	// Property accessors

	public Integer getRoomDecorateId() {
		return this.roomDecorateId;
	}

	public void setRoomDecorateId(Integer roomDecorateId) {
		this.roomDecorateId = roomDecorateId;
	}

	public String getRoomDecorateName() {
		return this.roomDecorateName;
	}

	public void setRoomDecorateName(String roomDecorateName) {
		this.roomDecorateName = roomDecorateName;
	}

	public Set getTbRooms() {
		return this.tbRooms;
	}

	public void setTbRooms(Set tbRooms) {
		this.tbRooms = tbRooms;
	}

}