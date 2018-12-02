package com.zhou.pms.po.homm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.alibaba.fastjson.annotation.JSONField;
import com.zhou.pms.po.hopm.Room;

public class Estates {
	private Integer estId; //主键，自增，无符号
	private String estCid; //房产证号
	private String estBid; //认购证号
	private Integer estIspay; //是否缴纳维修金，1:是/2:否
	private Double estRepairdeposit; //维修金金额
//	@JSONField(format="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date estDecodate; //装修时间
	private Integer estOrder; //主次排序号
	private String estRemark; //备注
	private Integer ownerId; //业主id
	private Integer roomId; // 房间id
	
	private MoveIn mi; //房间的入住状态
	
	private OwnerInfo ownerInfo; //业主基本信息对象
	private Room room; //房间对象
	
	public Integer getEstId() {
		return estId;
	}
	public void setEstId(Integer estId) {
		this.estId = estId;
	}
	public String getEstCid() {
		return estCid;
	}
	public void setEstCid(String estCid) {
		this.estCid = estCid;
	}
	public String getEstBid() {
		return estBid;
	}
	public void setEstBid(String estBid) {
		this.estBid = estBid;
	}
	public Integer getEstIspay() {
		return estIspay;
	}
	public void setEstIspay(Integer estIspay) {
		this.estIspay = estIspay;
	}
	public Double getEstRepairdeposit() {
		return estRepairdeposit;
	}
	public void setEstRepairdeposit(Double estRepairdeposit) {
		this.estRepairdeposit = estRepairdeposit;
	}
	public Date getEstDecodate() {
		return estDecodate;
	}
	public void setEstDecodate(Date estDecodate) {
		this.estDecodate = estDecodate;
	}
	public Integer getEstOrder() {
		return estOrder;
	}
	public void setEstOrder(Integer estOrder) {
		this.estOrder = estOrder;
	}
	public String getEstRemark() {
		return estRemark;
	}
	public void setEstRemark(String estRemark) {
		this.estRemark = estRemark;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public MoveIn getMi() {
		return mi;
	}
	public void setMi(MoveIn mi) {
		this.mi = mi;
	}
	public OwnerInfo getOwnerInfo() {
		return ownerInfo;
	}
	public void setOwnerInfo(OwnerInfo ownerInfo) {
		this.ownerInfo = ownerInfo;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Estates [estId=" + estId + ", estCid=" + estCid + ", estBid="
				+ estBid + ", estIspay=" + estIspay + ", estRepairdeposit="
				+ estRepairdeposit + ", estDecodate=" + estDecodate
				+ ", estOrder=" + estOrder + ", estRemark=" + estRemark
				+ ", ownerId=" + ownerId + ", roomId=" + roomId + ", mi=" + mi
				+ ", ownerInfo=" + ownerInfo + ", room=" + room + "]";
	}
}
