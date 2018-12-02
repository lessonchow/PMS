package com.zhou.pms.po.homm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.alibaba.fastjson.annotation.JSONField;

public class MoveIn {

	private Integer miId; //主键，自增，无符号
//	@JSONField(format="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date miDate; //入住时间
	private Integer miStatus; //使用状态，1:空闲/2:自主/3:出租/4:转卖
	private Integer estId; //业主房产登记信息id
	private Integer roomId; //房间ID 
	
	private Estates est; //业主房产登记表id（为了保持数据一致）
	
	@Override
	public String toString() {
		return "MoveIn [miId=" + miId + ", miDate=" + miDate + ", miStatus="
				+ miStatus + ", estId=" + estId + ", est=" + est + "]";
	}

	public Integer getMiId() {
		return miId;
	}

	public void setMiId(Integer miId) {
		this.miId = miId;
	}

	public Date getMiDate() {
		return miDate;
	}

	public void setMiDate(Date miDate) {
		this.miDate = miDate;
	}

	public Integer getMiStatus() {
		return miStatus;
	}

	public void setMiStatus(Integer miStatus) {
		this.miStatus = miStatus;
	}

	public Integer getEstId() {
		return estId;
	}

	public void setEstId(Integer estId) {
		this.estId = estId;
	}

	public Estates getEst() {
		return est;
	}

	public void setEst(Estates est) {
		this.est = est;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
}
