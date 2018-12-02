package com.zhou.pms.po.hopm;

import java.util.HashSet;
import java.util.Set;

/**
 * TbBuildingSort entity. @author MyEclipse Persistence Tools
 */

public class TbBuildingSort implements java.io.Serializable {

	// Fields

	private Integer sortId;
	private String sortName;
	private Set tbBuildings = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbBuildingSort() {
	}

	/** minimal constructor */
	public TbBuildingSort(Integer sortId) {
		this.sortId = sortId;
	}

	/** full constructor */
	public TbBuildingSort(Integer sortId, String sortName, Set tbBuildings) {
		this.sortId = sortId;
		this.sortName = sortName;
		this.tbBuildings = tbBuildings;
	}

	// Property accessors

	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public String getSortName() {
		return this.sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Set getTbBuildings() {
		return this.tbBuildings;
	}

	public void setTbBuildings(Set tbBuildings) {
		this.tbBuildings = tbBuildings;
	}

}