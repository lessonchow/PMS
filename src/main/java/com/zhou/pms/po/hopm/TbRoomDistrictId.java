package com.zhou.pms.po.hopm;

/**
 * TbRoomDistrictId entity. @author MyEclipse Persistence Tools
 */

public class TbRoomDistrictId implements java.io.Serializable {

	// Fields

	private Integer roomDistrictId;
	private String roomDistrictName;

	// Constructors

	/** default constructor */
	public TbRoomDistrictId() {
	}

	/** full constructor */
	public TbRoomDistrictId(Integer roomDistrictId, String roomDistrictName) {
		this.roomDistrictId = roomDistrictId;
		this.roomDistrictName = roomDistrictName;
	}

	// Property accessors

	public Integer getRoomDistrictId() {
		return this.roomDistrictId;
	}

	public void setRoomDistrictId(Integer roomDistrictId) {
		this.roomDistrictId = roomDistrictId;
	}

	public String getRoomDistrictName() {
		return this.roomDistrictName;
	}

	public void setRoomDistrictName(String roomDistrictName) {
		this.roomDistrictName = roomDistrictName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbRoomDistrictId))
			return false;
		TbRoomDistrictId castOther = (TbRoomDistrictId) other;

		return ((this.getRoomDistrictId() == castOther.getRoomDistrictId())
				|| (this.getRoomDistrictId() != null && castOther.getRoomDistrictId() != null
						&& this.getRoomDistrictId().equals(castOther.getRoomDistrictId())))
				&& ((this.getRoomDistrictName() == castOther.getRoomDistrictName())
						|| (this.getRoomDistrictName() != null && castOther.getRoomDistrictName() != null
								&& this.getRoomDistrictName().equals(castOther.getRoomDistrictName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRoomDistrictId() == null ? 0 : this.getRoomDistrictId().hashCode());
		result = 37 * result + (getRoomDistrictName() == null ? 0 : this.getRoomDistrictName().hashCode());
		return result;
	}

}