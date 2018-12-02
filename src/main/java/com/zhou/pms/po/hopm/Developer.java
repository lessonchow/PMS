package com.zhou.pms.po.hopm;

/**
 *��չ����
 */

public class Developer implements java.io.Serializable {

	// Fields

	private Integer devlpId;
	private String devlpCode;
	private String devlpName;
	private String devlpContact;
	private String devlpAddress;
	private String devlpRemark;
	private String devlpCorporate;
	private String devlpPhone;

	// Constructors

	/** default constructor */
	public Developer() {
	}

	/** full constructor */
	public Developer(Integer devlpId, String devlpCode, String devlpName, String devlpContact,
			String devlpAddress, String devlpRemark, String devlpCorporate, String devlpPhone) {
		this.devlpId = devlpId;
		this.devlpCode = devlpCode;
		this.devlpName = devlpName;
		this.devlpContact = devlpContact;
		this.devlpAddress = devlpAddress;
		this.devlpRemark = devlpRemark;
		this.devlpCorporate = devlpCorporate;
		this.devlpPhone = devlpPhone;
	}

	// Property accessors

	public Integer getDevlpId() {
		return this.devlpId;
	}

	public void setDevlpId(Integer devlpId) {
		this.devlpId = devlpId;
	}

	public String getDevlpCode() {
		return this.devlpCode;
	}

	public void setDevlpCode(String devlpCode) {
		this.devlpCode = devlpCode;
	}

	public String getDevlpName() {
		return this.devlpName;
	}

	public void setDevlpName(String devlpName) {
		this.devlpName = devlpName;
	}

	public String getDevlpContact() {
		return this.devlpContact;
	}

	public void setDevlpContact(String devlpContact) {
		this.devlpContact = devlpContact;
	}

	public String getDevlpAddress() {
		return this.devlpAddress;
	}

	public void setDevlpAddress(String devlpAddress) {
		this.devlpAddress = devlpAddress;
	}

	public String getDevlpRemark() {
		return this.devlpRemark;
	}

	public void setDevlpRemark(String devlpRemark) {
		this.devlpRemark = devlpRemark;
	}

	public String getDevlpCorporate() {
		return this.devlpCorporate;
	}

	public void setDevlpCorporate(String devlpCorporate) {
		this.devlpCorporate = devlpCorporate;
	}

	public String getDevlpPhone() {
		return this.devlpPhone;
	}

	public void setDevlpPhone(String devlpPhone) {
		this.devlpPhone = devlpPhone;
	}





}