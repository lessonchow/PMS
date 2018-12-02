package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbBuildingFinishlevel entity. @author MyEclipse Persistence Tools
 */

public class TbBuildingFinishlevel implements java.io.Serializable {

	// Fields

	private Integer finishLevelId;
	private String finishLevel;
	private Set tbBuildings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbBuildingFinishlevel() {
	}

	/** minimal constructor */
	public TbBuildingFinishlevel(Integer finishLevelId) {
		this.finishLevelId = finishLevelId;
	}

	/** full constructor */
	public TbBuildingFinishlevel(Integer finishLevelId, String finishLevel, Set tbBuildings) {
		this.finishLevelId = finishLevelId;
		this.finishLevel = finishLevel;
		this.tbBuildings = tbBuildings;
	}

	// Property accessors

	public Integer getFinishLevelId() {
		return this.finishLevelId;
	}

	public void setFinishLevelId(Integer finishLevelId) {
		this.finishLevelId = finishLevelId;
	}

	public String getFinishLevel() {
		return this.finishLevel;
	}

	public void setFinishLevel(String finishLevel) {
		this.finishLevel = finishLevel;
	}

	public Set getTbBuildings() {
		return this.tbBuildings;
	}

	public void setTbBuildings(Set tbBuildings) {
		this.tbBuildings = tbBuildings;
	}

}