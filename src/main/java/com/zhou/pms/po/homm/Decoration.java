package com.zhou.pms.po.homm;

import java.util.Date;

import com.zhou.pms.po.hopm.Room;

public class Decoration {

	private Integer decoId; //主键，自增，无符号
	private String decoApplyPerson; //申请人
	private String decoApplyPhone; //联系电话
	private Date decoApplyDate; //申请时间
	private Integer decoStatus; //状态，1:待审批/2:审批通过/3:已验收/4:已作废
	private String decoContent; //装修内容
	private Double decoDeposit; //装修保证金
	private User decoAuditUser; //审批人对象（用户表）
	private String decoAuditComment; //审批意见
	private Date decoAuditTime; //审批时间
	private String decoOrg; //施工单位
	private String decoOrgPerson; //负责人
	private String decoOrgPhone; //负责人电话
	private String decoStartdate; //施工开始日期
	private String decoFinishdate; //施工截止日期
	private String decoCheckPerson; //验收人
	private Date decoCheckDate; //验收日期
	private String decoCheckCommen; //验收意见
	private Double decoPenalty; //违约金
	private String decoRemark; //备注
	private Integer decoMark; //标识，1:物业人员录入/2:业主录入
	private Room room;
}
