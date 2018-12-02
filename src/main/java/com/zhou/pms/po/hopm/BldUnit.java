package com.zhou.pms.po.hopm;

import java.util.List;

/**
 * ��Ԫ��
 */

public class BldUnit implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer unitId;
	private String unitCode;
	private String unitName;
	private Integer unitRoomBegin;
	private Integer unitRoomEnd;
	private Integer bldId;
	private String unitRemark;
	private String unitIdRelation;
	private List<Room> rooms;
	private String bldCode;//只用作显示数据传输,不进行数据库保存
	// Constructors

	/** default constructor */
	public BldUnit() {}
	/** full constructor */
	public BldUnit(Integer unitId, String unitCode, String unitName,
			Integer unitRoomBegin, Integer unitRoomEnd, Integer bldId,String unitRemark,String unitIdRelation) {
		this.unitId = unitId;
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.unitRoomBegin = unitRoomBegin;
		this.unitRoomEnd = unitRoomEnd;
		this.bldId = bldId;
		this.unitRemark=unitRemark;
		this.unitIdRelation=unitIdRelation;
	}

	/**
	 * @return the unitId
	 */
	public Integer getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return the unitCode
	 */
	public String getUnitCode() {
		return unitCode;
	}

	/**
	 * @param unitCode the unitCode to set
	 */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	/**
	 * @return the unitRoomBegin
	 */
	public Integer getUnitRoomBegin() {
		return unitRoomBegin;
	}

	/**
	 * @param unitRoomBegin the unitRoomBegin to set
	 */
	public void setUnitRoomBegin(Integer unitRoomBegin) {
		this.unitRoomBegin = unitRoomBegin;
	}

	/**
	 * @return the unitRoomEnd
	 */
	public Integer getUnitRoomEnd() {
		return unitRoomEnd;
	}

	/**
	 * @param unitRoomEnd the unitRoomEnd to set
	 */
	public void setUnitRoomEnd(Integer unitRoomEnd) {
		this.unitRoomEnd = unitRoomEnd;
	}

	/**
	 * @return the bldId
	 */
	public Integer getBldId() {
		return bldId;
	}

	/**
	 * @param bldId the bldId to set
	 */
	public void setBldId(Integer bldId) {
		this.bldId = bldId;
	}



	/**
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUnitRemark() {
		return unitRemark;
	}

	public void setUnitRemark(String unitRemark) {
		this.unitRemark = unitRemark;
	}

	public String getUnitIdRelation() {
		return unitIdRelation;
	}

	public void setUnitIdRelation(String unitIdRelation) {
		this.unitIdRelation = unitIdRelation;
	}
	public String getBldCode() {
		return bldCode;
	}
	public void setBldCode(String bldCode) {
		this.bldCode = bldCode;
	}
	
	
	
	
}