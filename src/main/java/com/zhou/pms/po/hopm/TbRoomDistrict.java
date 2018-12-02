package com.zhou.pms.po.hopm;

/**
 * TbRoomDistrict entity. @author MyEclipse Persistence Tools
 */

public class TbRoomDistrict implements java.io.Serializable {

	// Fields

	private TbRoomDistrictId id;

	// Constructors

	/** default constructor */
	public TbRoomDistrict() {
	}

	/** full constructor */
	public TbRoomDistrict(TbRoomDistrictId id) {
		this.id = id;
	}

	// Property accessors

	public TbRoomDistrictId getId() {
		return this.id;
	}

	public void setId(TbRoomDistrictId id) {
		this.id = id;
	}

}