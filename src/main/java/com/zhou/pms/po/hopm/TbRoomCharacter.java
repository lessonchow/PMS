package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbRoomCharacter entity. @author MyEclipse Persistence Tools
 */

public class TbRoomCharacter implements java.io.Serializable {

	// Fields

	private Integer roomCharacterId;
	private String roomCharacterName;
	private Set tbRooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbRoomCharacter() {
	}

	/** minimal constructor */
	public TbRoomCharacter(Integer roomCharacterId) {
		this.roomCharacterId = roomCharacterId;
	}

	/** full constructor */
	public TbRoomCharacter(Integer roomCharacterId, String roomCharacterName, Set tbRooms) {
		this.roomCharacterId = roomCharacterId;
		this.roomCharacterName = roomCharacterName;
		this.tbRooms = tbRooms;
	}

	// Property accessors

	public Integer getRoomCharacterId() {
		return this.roomCharacterId;
	}

	public void setRoomCharacterId(Integer roomCharacterId) {
		this.roomCharacterId = roomCharacterId;
	}

	public String getRoomCharacterName() {
		return this.roomCharacterName;
	}

	public void setRoomCharacterName(String roomCharacterName) {
		this.roomCharacterName = roomCharacterName;
	}

	public Set getTbRooms() {
		return this.tbRooms;
	}

	public void setTbRooms(Set tbRooms) {
		this.tbRooms = tbRooms;
	}

}