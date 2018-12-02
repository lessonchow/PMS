package com.zhou.pms.po.homm;

import java.util.Date;

import com.zhou.pms.po.hopm.Room;

public class Extension {

	private Integer exId; //主键，自增，无符号
	private Double exArea; //加建面积
	private Date exDate; //加建时间
	private Integer exStatus; //状态，1:正常/2:停用
	private String exInfo; //加建说明
	private Room room;
}
