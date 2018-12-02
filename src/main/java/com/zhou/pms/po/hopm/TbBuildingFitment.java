package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbBuildingFitment entity. @author MyEclipse Persistence Tools
 */

public class TbBuildingFitment implements java.io.Serializable {

	// Fields

	private Integer fitId;
	private String fitName;
	private Set tbBuildings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbBuildingFitment() {
	}

	/** minimal constructor */
	public TbBuildingFitment(Integer fitId) {
		this.fitId = fitId;
	}

	/** full constructor */
	public TbBuildingFitment(Integer fitId, String fitName, Set tbBuildings) {
		this.fitId = fitId;
		this.fitName = fitName;
		this.tbBuildings = tbBuildings;
	}

	// Property accessors

	public Integer getFitId() {
		return this.fitId;
	}

	public void setFitId(Integer fitId) {
		this.fitId = fitId;
	}

	public String getFitName() {
		return this.fitName;
	}

	public void setFitName(String fitName) {
		this.fitName = fitName;
	}

	public Set getTbBuildings() {
		return this.tbBuildings;
	}

	public void setTbBuildings(Set tbBuildings) {
		this.tbBuildings = tbBuildings;
	}

}