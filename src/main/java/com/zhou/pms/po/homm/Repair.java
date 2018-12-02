package com.zhou.pms.po.homm;

import java.util.Date;

import com.zhou.pms.po.hopm.Room;

public class Repair {

	private Integer repairId; //主键，自增，无符号
	private String repairApplyPerson; //申请人
	private String repairApplyPhone; //联系电话
	private Date repairApplyDate; //申请时间
	private Integer repairStatus; //状态，1:待审批/2:审批通过/3:已验收
	private String repairContent; //请修内容
	private User repairAuditUser; //审批人（用户表）
	private Double repairPayment; //修理费用
	private String repairAuditComment; //审批意见
	private Date repairAuditTime; //审批时间
	private String repairOrg; //施工单位
	private String repairOrgPerson; //负责人
	private String repairOrgPhone; //负责人电话
	private Date repairStartdate; //施工开始日期
	private Date repairFinishdate; //施工截止日期
	private String repairCheckPerson; //验收人
	private Date repairCheckDate; //验收日期
	private String repairCheckComment; //验收意见
	private String repairRemark; //备注
	private Room room; 
}
