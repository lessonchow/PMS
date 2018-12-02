package com.zhou.pms.po.hopm;

/**
 * TbBuildingFunction entity. @author MyEclipse Persistence Tools
 */

public class TbBuildingFunction implements java.io.Serializable {

	// Fields

	private Integer funId;
	private String funName;

	// Constructors

	/** default constructor */
	public TbBuildingFunction() {
	}

	/** minimal constructor */
	public TbBuildingFunction(Integer funId) {
		this.funId = funId;
	}

	/** full constructor */
	public TbBuildingFunction(Integer funId, String funName) {
		this.funId = funId;
		this.funName = funName;
	}

	// Property accessors

	public Integer getFunId() {
		return this.funId;
	}

	public void setFunId(Integer funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return this.funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

}