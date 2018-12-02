package com.zhou.pms.po.hopm;

public class Company {
	// Fields

	private Integer ldcId;
	private String ldcCode;
	private String ldcName;
	private Integer ldcPid;

	// Constructors

	/** default constructor */
	public Company() {
	}


	/** full constructor */
	public Company(Integer ldcId, String ldcCode, String ldcName, Integer ldcPid) {
		this.ldcId = ldcId;
		this.ldcCode = ldcCode;
		this.ldcName = ldcName;
		this.ldcPid = ldcPid;
	}

	// Property accessors

	public Integer getLdcId() {
		return this.ldcId;
	}

	public void setLdcId(Integer ldcId) {
		this.ldcId = ldcId;
	}

	public String getLdcCode() {
		return this.ldcCode;
	}

	public void setLdcCode(String ldcCode) {
		this.ldcCode = ldcCode;
	}

	public String getLdcName() {
		return this.ldcName;
	}

	public void setLdcName(String ldcName) {
		this.ldcName = ldcName;
	}

	public Integer getLdcPid() {
		return this.ldcPid;
	}

	public void setLdcPid(Integer ldcPid) {
		this.ldcPid = ldcPid;
	}
}
