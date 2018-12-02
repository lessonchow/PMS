package com.zhou.pms.po.homm;

import java.util.Date;

import com.zhou.pms.po.hopm.Room;

public class Check {

	private Integer checkId; //主键，自增，无符号
	private String checkItem; //验收项目
	private Date checkDate; //验收日期
	private String checkConfirmdate; //确认日期
	private Integer checkIspass; //是否合格，1:合格/2:不合格
	private String checkPerson; //验收人员
	private String checkOwner_comment; //业主意见
	private String checkHpComment; //房管员意见
	private String checkRemark; //补充备注
	private Room room;
}
