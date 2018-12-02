package com.zhou.pms.po.homm;

import java.util.Date;

import com.zhou.pms.po.hopm.Room;

public class Complaint {

	private Integer compId; //主键，自增，无符号
	private String compPerson; //投诉人
	private String compPersonPhone; //联系电话
	private Date compDate; //投诉时间
	private Integer compType; //状态，1:物业问题/2:收费问题/3:卫生问题/4:安全问题
	private Integer compStatus; //状态，1:待受理/2:受理中/3:受理完毕
	private String compRecep; //接待人
	private String compContent; //投诉内容
	private User compAcceptUser; //受理人对象（用户表）
	private Date compAcceptTime; //受理时间
	private String compResult; //受理结果
	private User compRevisitUser; //回访人对象（用户表）
	private Date compRevisitRime; //回访时间
	private Integer compIsok; //是否满意，1:满意/2:不满意
	private String compComment; //业主评价
	private Integer compMark; //标识，1:物业人员录入/2:业主录入
	private Room room;
}
