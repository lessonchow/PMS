package com.zhou.pms.po.hopm;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * AbstractTbBuilderId entity provides the base persistence definition of the
 * TbBuilderId entity. @author MyEclipse Persistence Tools
 */

public class Building implements java.io.Serializable {

	// Fields

	private Integer bldId;
	private String bldCode;
	private String bldName;
	private Integer bldUnitNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bldFinishedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bldReceiptDate;
	private String bldPresaleCode;
	private String bldBuilderCode;
	private Float bldArea;
	private Float bldUseArea;
	private String bldRemarke;
	private Integer consId;
	private Integer funId;
	private Integer sortId;
	private Integer fitId;
	private Integer unitFinishLevel;
	private Integer propId;
	private List<BldUnit> units;
	private String bldIdRelation;
	// Constructors

	/** default constructor */
	public Building() {
	}
	
	
	public Building(Integer bldId, String bldCode, String bldName, Integer bldUnitNum, Date bldFinishedDate,
			Date bldReceiptDate, String bldPresaleCode, String bldBuilderCode, Float bldArea, Float bldUseArea,
			String bldRemarke, Integer consId,String bldIdRelation) {
		this.bldId=bldId;
		this.bldCode = bldCode;
		this.bldName = bldName;
		this.bldUnitNum = bldUnitNum;
		this.bldFinishedDate = bldFinishedDate;
		this.bldReceiptDate = bldReceiptDate;
		this.bldPresaleCode = bldPresaleCode;
		this.bldBuilderCode = bldBuilderCode;
		this.bldArea = bldArea;
		this.bldUseArea = bldUseArea;
		this.bldRemarke = bldRemarke;
		this.consId = consId;
		this.bldIdRelation=bldIdRelation;
	}





	/** full constructor */
	public Building(Integer bldId, String bldCode, String bldName, Integer bldUnitNum, Date bldFinishedDate,
			Date bldReceiptDate, String bldPresaleCode, String bldBuilderCode, Float bldArea, Float bldUseArea,
			String bldRemarke, Integer consId, Integer funId, Integer sortId, Integer fitId, Integer unitFinishLevel,
			Integer propId) {
		this.bldId = bldId;
		this.bldCode = bldCode;
		this.bldName = bldName;
		this.bldUnitNum = bldUnitNum;
		this.bldFinishedDate = bldFinishedDate;
		this.bldReceiptDate = bldReceiptDate;
		this.bldPresaleCode = bldPresaleCode;
		this.bldBuilderCode = bldBuilderCode;
		this.bldArea = bldArea;
		this.bldUseArea = bldUseArea;
		this.bldRemarke = bldRemarke;
		this.consId = consId;
		this.funId = funId;
		this.sortId = sortId;
		this.fitId = fitId;
		this.unitFinishLevel = unitFinishLevel;
		this.propId = propId;
	}

	// Property accessors

	public Integer getBldId() {
		return this.bldId;
	}

	public void setBldId(Integer bldId) {
		this.bldId = bldId;
	}

	public String getBldCode() {
		return this.bldCode;
	}

	public void setBldCode(String bldCode) {
		this.bldCode = bldCode;
	}

	public String getBldName() {
		return this.bldName;
	}

	public void setBldName(String bldName) {
		this.bldName = bldName;
	}

	public Integer getBldUnitNum() {
		return this.bldUnitNum;
	}

	public void setBldUnitNum(Integer bldUnitNum) {
		this.bldUnitNum = bldUnitNum;
	}

	public Date getBldFinishedDate() {
		return this.bldFinishedDate;
	}

	public void setBldFinishedDate(Date bldFinishedDate) {
		this.bldFinishedDate = bldFinishedDate;
	}

	public Date getBldReceiptDate() {
		return this.bldReceiptDate;
	}

	public void setBldReceiptDate(Date bldReceiptDate) {
		this.bldReceiptDate = bldReceiptDate;
	}

	public String getBldPresaleCode() {
		return this.bldPresaleCode;
	}

	public void setBldPresaleCode(String bldPresaleCode) {
		this.bldPresaleCode = bldPresaleCode;
	}

	public String getBldBuilderCode() {
		return this.bldBuilderCode;
	}

	public void setBldBuilderCode(String bldBuilderCode) {
		this.bldBuilderCode = bldBuilderCode;
	}

	public Float getBldArea() {
		return this.bldArea;
	}

	public void setBldArea(Float bldArea) {
		this.bldArea = bldArea;
	}

	public Float getBldUseArea() {
		return this.bldUseArea;
	}

	public void setBldUseArea(Float bldUseArea) {
		this.bldUseArea = bldUseArea;
	}

	public String getBldRemarke() {
		return this.bldRemarke;
	}

	public void setBldRemarke(String bldRemarke) {
		this.bldRemarke = bldRemarke;
	}

	public Integer getconsId() {
		return this.consId;
	}

	public void setconsId(Integer consId) {
		this.consId = consId;
	}

	public Integer getFunId() {
		return this.funId;
	}

	public void setFunId(Integer funId) {
		this.funId = funId;
	}

	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Integer getFitId() {
		return this.fitId;
	}

	public void setFitId(Integer fitId) {
		this.fitId = fitId;
	}

	public Integer getUnitFinishLevel() {
		return this.unitFinishLevel;
	}

	public void setUnitFinishLevel(Integer unitFinishLevel) {
		this.unitFinishLevel = unitFinishLevel;
	}

	public Integer getPropId() {
		return this.propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Building))
			return false;
		Building castOther = (Building) other;

		return ((this.getBldId() == castOther.getBldId()) || (this.getBldId() != null && castOther.getBldId() != null
				&& this.getBldId().equals(castOther.getBldId())))
				&& ((this.getBldCode() == castOther.getBldCode()) || (this.getBldCode() != null
						&& castOther.getBldCode() != null && this.getBldCode().equals(castOther.getBldCode())))
				&& ((this.getBldName() == castOther.getBldName()) || (this.getBldName() != null
						&& castOther.getBldName() != null && this.getBldName().equals(castOther.getBldName())))
				&& ((this.getBldUnitNum() == castOther.getBldUnitNum()) || (this.getBldUnitNum() != null
						&& castOther.getBldUnitNum() != null && this.getBldUnitNum().equals(castOther.getBldUnitNum())))
				&& ((this.getBldFinishedDate() == castOther.getBldFinishedDate())
						|| (this.getBldFinishedDate() != null && castOther.getBldFinishedDate() != null
								&& this.getBldFinishedDate().equals(castOther.getBldFinishedDate())))
				&& ((this.getBldReceiptDate() == castOther.getBldReceiptDate())
						|| (this.getBldReceiptDate() != null && castOther.getBldReceiptDate() != null
								&& this.getBldReceiptDate().equals(castOther.getBldReceiptDate())))
				&& ((this.getBldPresaleCode() == castOther.getBldPresaleCode())
						|| (this.getBldPresaleCode() != null && castOther.getBldPresaleCode() != null
								&& this.getBldPresaleCode().equals(castOther.getBldPresaleCode())))
				&& ((this.getBldBuilderCode() == castOther.getBldBuilderCode())
						|| (this.getBldBuilderCode() != null && castOther.getBldBuilderCode() != null
								&& this.getBldBuilderCode().equals(castOther.getBldBuilderCode())))
				&& ((this.getBldArea() == castOther.getBldArea()) || (this.getBldArea() != null
						&& castOther.getBldArea() != null && this.getBldArea().equals(castOther.getBldArea())))
				&& ((this.getBldUseArea() == castOther.getBldUseArea()) || (this.getBldUseArea() != null
						&& castOther.getBldUseArea() != null && this.getBldUseArea().equals(castOther.getBldUseArea())))
				&& ((this.getBldRemarke() == castOther.getBldRemarke()) || (this.getBldRemarke() != null
						&& castOther.getBldRemarke() != null && this.getBldRemarke().equals(castOther.getBldRemarke())))
				&& ((this.getconsId() == castOther.getconsId()) || (this.getconsId() != null
						&& castOther.getconsId() != null && this.getconsId().equals(castOther.getconsId())))
				&& ((this.getFunId() == castOther.getFunId()) || (this.getFunId() != null
						&& castOther.getFunId() != null && this.getFunId().equals(castOther.getFunId())))
				&& ((this.getSortId() == castOther.getSortId()) || (this.getSortId() != null
						&& castOther.getSortId() != null && this.getSortId().equals(castOther.getSortId())))
				&& ((this.getFitId() == castOther.getFitId()) || (this.getFitId() != null
						&& castOther.getFitId() != null && this.getFitId().equals(castOther.getFitId())))
				&& ((this.getUnitFinishLevel() == castOther.getUnitFinishLevel())
						|| (this.getUnitFinishLevel() != null && castOther.getUnitFinishLevel() != null
								&& this.getUnitFinishLevel().equals(castOther.getUnitFinishLevel())))
				&& ((this.getPropId() == castOther.getPropId()) || (this.getPropId() != null
						&& castOther.getPropId() != null && this.getPropId().equals(castOther.getPropId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBldId() == null ? 0 : this.getBldId().hashCode());
		result = 37 * result + (getBldCode() == null ? 0 : this.getBldCode().hashCode());
		result = 37 * result + (getBldName() == null ? 0 : this.getBldName().hashCode());
		result = 37 * result + (getBldUnitNum() == null ? 0 : this.getBldUnitNum().hashCode());
		result = 37 * result + (getBldFinishedDate() == null ? 0 : this.getBldFinishedDate().hashCode());
		result = 37 * result + (getBldReceiptDate() == null ? 0 : this.getBldReceiptDate().hashCode());
		result = 37 * result + (getBldPresaleCode() == null ? 0 : this.getBldPresaleCode().hashCode());
		result = 37 * result + (getBldBuilderCode() == null ? 0 : this.getBldBuilderCode().hashCode());
		result = 37 * result + (getBldArea() == null ? 0 : this.getBldArea().hashCode());
		result = 37 * result + (getBldUseArea() == null ? 0 : this.getBldUseArea().hashCode());
		result = 37 * result + (getBldRemarke() == null ? 0 : this.getBldRemarke().hashCode());
		result = 37 * result + (getconsId() == null ? 0 : this.getconsId().hashCode());
		result = 37 * result + (getFunId() == null ? 0 : this.getFunId().hashCode());
		result = 37 * result + (getSortId() == null ? 0 : this.getSortId().hashCode());
		result = 37 * result + (getFitId() == null ? 0 : this.getFitId().hashCode());
		result = 37 * result + (getUnitFinishLevel() == null ? 0 : this.getUnitFinishLevel().hashCode());
		result = 37 * result + (getPropId() == null ? 0 : this.getPropId().hashCode());
		return result;
	}

	public List<BldUnit> getUnits() {
		return units;
	}

	public void setUnits(List<BldUnit> units) {
		this.units = units;
	}


	public String getBldIdRelation() {
		return bldIdRelation;
	}


	public void setBldIdRelation(String bldIdRelation) {
		this.bldIdRelation = bldIdRelation;
	}

}