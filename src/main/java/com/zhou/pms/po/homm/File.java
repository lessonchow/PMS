package com.zhou.pms.po.homm;

public class File {

	private Integer fileId; //主键，自增，无符号
	private String fileName; //附件文件名
	private Decoration decoUser; //业主装修信息表
	private Complaint compUser; //业主投诉表
	private Repair repairUser; //业主请修表
}
