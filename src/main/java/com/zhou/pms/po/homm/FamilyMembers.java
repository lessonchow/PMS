package com.zhou.pms.po.homm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FamilyMembers {
	
	private Integer fmId; // 主键
	private String fmName; //成员姓名
	private String fmPhone; //成员电话号码
	private Integer fmGender; // 性别，1:男/2:女；默认1'
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date fmBirthday; // 成员生日
	private String fmCertType; // 证件类型
	private String fmCertNo; //成员证件号码
	private String fmRelationship; //与业主关系
	private String fmEducation; //成员学历
	private String fmWork; //工作单位
	private String fmRemark; //备注
	private String fmPicname; //成员照片名字
	private Integer ownerId; // 业主ID
	
//	private String ownerName; // 业主姓名，这个属性可以去掉
	
//    private OwnerInfo ownerInfo; //业主基本信息对象

	public Integer getFmId() {
		return fmId;
	}

	public void setFmId(Integer fmId) {
		this.fmId = fmId;
	}

	public String getFmName() {
		return fmName;
	}

	public void setFmName(String fmName) {
		this.fmName = fmName;
	}

	public String getFmPhone() {
		return fmPhone;
	}

	public void setFmPhone(String fmPhone) {
		this.fmPhone = fmPhone;
	}

	public Integer getFmGender() {
		return fmGender;
	}

	public void setFmGender(Integer fmGender) {
		this.fmGender = fmGender;
	}

	public Date getFmBirthday() {
		return fmBirthday;
	}

	public void setFmBirthday(Date fmBirthday) {
		this.fmBirthday = fmBirthday;
	}

	public String getFmCertType() {
		return fmCertType;
	}

	public void setFmCertType(String fmCertType) {
		this.fmCertType = fmCertType;
	}

	public String getFmCertNo() {
		return fmCertNo;
	}

	public void setFmCertNo(String fmCertNo) {
		this.fmCertNo = fmCertNo;
	}

	public String getFmRelationship() {
		return fmRelationship;
	}

	public void setFmRelationship(String fmRelationship) {
		this.fmRelationship = fmRelationship;
	}

	public String getFmEducation() {
		return fmEducation;
	}

	public void setFmEducation(String fmEducation) {
		this.fmEducation = fmEducation;
	}

	public String getFmWork() {
		return fmWork;
	}

	public void setFmWork(String fmWork) {
		this.fmWork = fmWork;
	}

	public String getFmRemark() {
		return fmRemark;
	}

	public void setFmRemark(String fmRemark) {
		this.fmRemark = fmRemark;
	}

	public String getFmPicname() {
		return fmPicname;
	}

	public void setFmPicname(String fmPicname) {
		this.fmPicname = fmPicname;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
}
