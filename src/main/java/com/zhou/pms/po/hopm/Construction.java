package com.zhou.pms.po.hopm;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * AbstractTbResidence entity provides the base persistence definition of the
 * TbResidence entity. @author MyEclipse Persistence Tools
 */

public class Construction implements java.io.Serializable {

	// Fields

	private Integer consId;
	private String consCode;
	private Float consSumArea;
	private Float consGspaceArea;
	@NotNull(message="楼宇数量不能为空")
	@Digits(message="请填写正确数字", fraction = 0, integer = 0)
	private Integer consTotal;
	private String consAddress;
	@NotNull(message="名称不能为空")
	private String consName;
	private Float consBuildingArea;
	private Float consRoadArea;
	private String consDirector;
	private Integer consTypeId;
	@NotNull(message="请选择地产商")
	private Integer ldcId;
	private Integer devlpId;
	private Company company;
	private Developer developer;
	private List<Building> building;
	// Constructors
	public Construction(){}
	/** full constructor */
	
	public Construction(Integer consId, String consCode, Float consSumArea, Float consGspaceArea, Integer consTotal,
			String consAddress, String consName, Float consBuildingArea, Float consRoadArea, String consDirector,
			Integer ldcId,Integer devlpId) {
		this.consId = consId;
		this.consCode = consCode;
		this.consSumArea = consSumArea;
		this.setConsGspaceArea(consGspaceArea);
		this.consTotal = consTotal;
		this.consAddress = consAddress;
		this.consName = consName;
		this.consBuildingArea = consBuildingArea;
		this.consRoadArea = consRoadArea;
		this.consDirector = consDirector;
		this.ldcId = ldcId;
		this.devlpId=devlpId;
	}


	/**
	 * @return the consId
	 */
	public Integer getConsId() {
		return consId;
	}


	/**
	 * @param consId the consId to set
	 */
	public void setConsId(Integer consId) {
		this.consId = consId;
	}

	/**
	 * @return the consCode
	 */
	public String getConsCode() {
		return consCode;
	}

	/**
	 * @param consCode the consCode to set
	 */
	public void setConsCode(String consCode) {
		this.consCode = consCode;
	}

	/**
	 * @return the consSumArea
	 */
	public Float getConsSumArea() {
		return consSumArea;
	}

	/**
	 * @param consSumArea the consSumArea to set
	 */
	public void setConsSumArea(Float consSumArea) {
		this.consSumArea = consSumArea;
	}



	/**
	 * @return the consTotal
	 */
	public Integer getConsTotal() {
		return consTotal;
	}

	/**
	 * @param consTotal the consTotal to set
	 */
	public void setConsTotal(Integer consTotal) {
		this.consTotal = consTotal;
	}

	/**
	 * @return the consAddress
	 */
	public String getConsAddress() {
		return consAddress;
	}

	/**
	 * @param consAddress the consAddress to set
	 */
	public void setConsAddress(String consAddress) {
		this.consAddress = consAddress;
	}

	/**
	 * @return the consName
	 */
	public String getConsName() {
		return consName;
	}

	/**
	 * @param consName the consName to set
	 */
	public void setConsName(String consName) {
		this.consName = consName;
	}

	/**
	 * @return the consBuildingArea
	 */
	public Float getConsBuildingArea() {
		return consBuildingArea;
	}

	/**
	 * @param consBuildingArea the consBuildingArea to set
	 */
	public void setConsBuildingArea(Float consBuildingArea) {
		this.consBuildingArea = consBuildingArea;
	}

	/**
	 * @return the consRoadArea
	 */
	public Float getConsRoadArea() {
		return consRoadArea;
	}

	/**
	 * @param consRoadArea the consRoadArea to set
	 */
	public void setConsRoadArea(Float consRoadArea) {
		this.consRoadArea = consRoadArea;
	}

	/**
	 * @return the consDirector
	 */
	public String getConsDirector() {
		return consDirector;
	}

	/**
	 * @param consDirector the consDirector to set
	 */
	public void setConsDirector(String consDirector) {
		this.consDirector = consDirector;
	}

	/**
	 * @return the ldcId
	 */
	public Integer getLdcId() {
		return ldcId;
	}

	/**
	 * @param ldcId the ldcId to set
	 */
	public void setLdcId(Integer ldcId) {
		this.ldcId = ldcId;
	}



	public Integer getConsTypeId() {
		return consTypeId;
	}


	public void setConsTypeId(Integer consTypeId) {
		this.consTypeId = consTypeId;
	}
	public Integer getDevlpId() {
		return devlpId;
	}
	public void setDevlpId(Integer devlpId) {
		this.devlpId = devlpId;
	}
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public Float getConsGspaceArea() {
		return consGspaceArea;
	}
	public void setConsGspaceArea(Float consGspaceArea) {
		this.consGspaceArea = consGspaceArea;
	}
	public List<Building> getBuilding() {
		return building;
	}
	public void setBuilding(List<Building> building) {
		this.building = building;
	}
	

	// Property accessors

	

}