package com.zhou.pms.po.homm;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.alibaba.fastjson.annotation.JSONField;

public class OwnerInfo {

	private Integer ownerId; // 主键
	private Integer ldcId; // 经营公司id
	private Integer ownerType; // 业主类型，1:正式业主/2:临时业主
	private String ownerCode; // 业主编码，唯一键
	private String ownerName; // 业主姓名
	private Integer ownerGender; // 性别，1:男/2:女；默认1
//	@JSONField(format="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date ownerBirthday; // 业主生日
	private String ownerRace; // 业主民族
	private String ownerEducation; // 业主学历
	private String ownerCountry; // 业主国籍
	private String ownerHometown; // 业主籍贯
	private String ownerCertType; // 业主证件类型
	private String ownerCertNo; // 业主证件号码
	private String ownerWork; // 工作单位
	private String ownerWorkPosition; // 职务
	private String ownerMobile; // 业主手机
	private String ownerZipcode; // 邮编
	private String ownerAdd; // 联系地址
	private String ownerUrgentcontact; // 紧急联系人
	private String ownerUrgentcontactPhone; // 紧急联系人电话
	private String ownerUrgentcontactAdd; // 紧急联系人联系地址
	private String ownerBank; // 开户行
	private String ownerBankaccount; // 银行账号
	private String ownerPolice; // 所在派出所
	private Integer ownerStatus; // 状态，1:正常/2:停用
	private String ownerRemark; // 备注
	private String ownerPicname; // 照片名字
	
	private String ldcName; //经营公司名字
	private Integer fmCount; // 家庭成员数量
	private Integer estCount; //名下房产数量
	
//	private List<Company> ldcList; // 经营公司集合
	
//	private List<FamilyMembers> fmList; // 家庭成员集合
//	private List<Estates> estList; // 名下房产集合
	
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getLdcId() {
		return ldcId;
	}
	public void setLdcId(Integer ldcId) {
		this.ldcId = ldcId;
	}
	public Integer getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Integer getOwnerGender() {
		return ownerGender;
	}
	public void setOwnerGender(Integer ownerGender) {
		this.ownerGender = ownerGender;
	}
	public Date getOwnerBirthday() {
		return ownerBirthday;
	}
	public void setOwnerBirthday(Date ownerBirthday) {
		this.ownerBirthday = ownerBirthday;
	}
	public String getOwnerRace() {
		return ownerRace;
	}
	public void setOwnerRace(String ownerRace) {
		this.ownerRace = ownerRace;
	}
	public String getOwnerEducation() {
		return ownerEducation;
	}
	public void setOwnerEducation(String ownerEducation) {
		this.ownerEducation = ownerEducation;
	}
	public String getOwnerCountry() {
		return ownerCountry;
	}
	public void setOwnerCountry(String ownerCountry) {
		this.ownerCountry = ownerCountry;
	}
	public String getOwnerHometown() {
		return ownerHometown;
	}
	public void setOwnerHometown(String ownerHometown) {
		this.ownerHometown = ownerHometown;
	}
	public String getOwnerCertType() {
		return ownerCertType;
	}
	public void setOwnerCertType(String ownerCertType) {
		this.ownerCertType = ownerCertType;
	}
	public String getOwnerCertNo() {
		return ownerCertNo;
	}
	public void setOwnerCertNo(String ownerCertNo) {
		this.ownerCertNo = ownerCertNo;
	}
	public String getOwnerWork() {
		return ownerWork;
	}
	public void setOwnerWork(String ownerWork) {
		this.ownerWork = ownerWork;
	}
	public String getOwnerWorkPosition() {
		return ownerWorkPosition;
	}
	public void setOwnerWorkPosition(String ownerWorkPosition) {
		this.ownerWorkPosition = ownerWorkPosition;
	}
	public String getOwnerMobile() {
		return ownerMobile;
	}
	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}
	public String getOwnerZipcode() {
		return ownerZipcode;
	}
	public void setOwnerZipcode(String ownerZipcode) {
		this.ownerZipcode = ownerZipcode;
	}
	public String getOwnerAdd() {
		return ownerAdd;
	}
	public void setOwnerAdd(String ownerAdd) {
		this.ownerAdd = ownerAdd;
	}
	public String getOwnerUrgentcontact() {
		return ownerUrgentcontact;
	}
	public void setOwnerUrgentcontact(String ownerUrgentcontact) {
		this.ownerUrgentcontact = ownerUrgentcontact;
	}
	public String getOwnerUrgentcontactPhone() {
		return ownerUrgentcontactPhone;
	}
	public void setOwnerUrgentcontactPhone(String ownerUrgentcontactPhone) {
		this.ownerUrgentcontactPhone = ownerUrgentcontactPhone;
	}
	public String getOwnerUrgentcontactAdd() {
		return ownerUrgentcontactAdd;
	}
	public void setOwnerUrgentcontactAdd(String ownerUrgentcontactAdd) {
		this.ownerUrgentcontactAdd = ownerUrgentcontactAdd;
	}
	public String getOwnerBank() {
		return ownerBank;
	}
	public void setOwnerBank(String ownerBank) {
		this.ownerBank = ownerBank;
	}
	public String getOwnerBankaccount() {
		return ownerBankaccount;
	}
	public void setOwnerBankaccount(String ownerBankaccount) {
		this.ownerBankaccount = ownerBankaccount;
	}
	public String getOwnerPolice() {
		return ownerPolice;
	}
	public void setOwnerPolice(String ownerPolice) {
		this.ownerPolice = ownerPolice;
	}
	public Integer getOwnerStatus() {
		return ownerStatus;
	}
	public void setOwnerStatus(Integer ownerStatus) {
		this.ownerStatus = ownerStatus;
	}
	public String getOwnerRemark() {
		return ownerRemark;
	}
	public void setOwnerRemark(String ownerRemark) {
		this.ownerRemark = ownerRemark;
	}
	public String getOwnerPicname() {
		return ownerPicname;
	}
	public void setOwnerPicname(String ownerPicname) {
		this.ownerPicname = ownerPicname;
	}
	public String getLdcName() {
		return ldcName;
	}
	public void setLdcName(String ldcName) {
		this.ldcName = ldcName;
	}
	public Integer getFmCount() {
		return fmCount;
	}
	public void setFmCount(Integer fmCount) {
		this.fmCount = fmCount;
	}
	public Integer getEstCount() {
		return estCount;
	}
	public void setEstCount(Integer estCount) {
		this.estCount = estCount;
	}
//	public List<Company> getLdcList() {
//		return ldcList;
//	}
//	public void setLdcList(List<Company> ldcList) {
//		this.ldcList = ldcList;
//	}
	@Override
	public String toString() {
		return "OwnerInfo [ownerId=" + ownerId + ", ldcId=" + ldcId
				+ ", ownerType=" + ownerType + ", ownerCode=" + ownerCode
				+ ", ownerName=" + ownerName + ", ownerGender=" + ownerGender
				+ ", ownerBirthday=" + ownerBirthday + ", ownerRace="
				+ ownerRace + ", ownerEducation=" + ownerEducation
				+ ", ownerCountry=" + ownerCountry + ", ownerHometown="
				+ ownerHometown + ", ownerCertType=" + ownerCertType
				+ ", ownerCertNo=" + ownerCertNo + ", ownerWork=" + ownerWork
				+ ", ownerWorkPosition=" + ownerWorkPosition + ", ownerMobile="
				+ ownerMobile + ", ownerZipcode=" + ownerZipcode
				+ ", ownerAdd=" + ownerAdd + ", ownerUrgentcontact="
				+ ownerUrgentcontact + ", ownerUrgentcontactPhone="
				+ ownerUrgentcontactPhone + ", ownerUrgentcontactAdd="
				+ ownerUrgentcontactAdd + ", ownerBank=" + ownerBank
				+ ", ownerBankaccount=" + ownerBankaccount + ", ownerPolice="
				+ ownerPolice + ", ownerStatus=" + ownerStatus
				+ ", ownerRemark=" + ownerRemark + ", ownerPicname="
				+ ownerPicname + ", ldcName=" + ldcName + ", fmCount="
				+ fmCount + ", estCount=" + estCount + ", ldcList=" + "]";
	}
	
}