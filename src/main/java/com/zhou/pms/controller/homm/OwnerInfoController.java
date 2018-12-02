package com.zhou.pms.controller.homm;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhou.pms.commons.PMSException;
import com.zhou.pms.commons.PageUtils;
import com.zhou.pms.dao.hopm.RoomMapper;
import com.zhou.pms.po.homm.Estates;
import com.zhou.pms.po.homm.FamilyMembers;
import com.zhou.pms.po.homm.OwnerInfo;
import com.zhou.pms.po.hopm.Company;
import com.zhou.pms.service.homm.IOwnerInfoService;
import com.zhou.pms.vo.InfoVo;

@Controller
@RequestMapping("/homm/ownerinfo")
public class OwnerInfoController {
	
	@Resource
	private IOwnerInfoService oiService;
	
	/**
	 * 分页获取全部业主信息或通过条件获取业主信息（通过页面控制信息条数达到一定数量才需要分页）
	 * @param ownerInfo
	 * @param currpage 
	 * @param roomId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getownerinfolist",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getOwerInfoList (OwnerInfo ownerInfo, String currpage, String roomId ) throws Exception {
//		List<OwnerInfo> oiList = new ArrayList<OwnerInfo>();
		PageUtils pageUtils = new PageUtils();
		Integer ownerId = null;
		if (currpage == null || currpage == "") { //如果上层没有传页码，则页码为第一页
			currpage = "1";
		}
//		System.out.println(ownerInfo);
		try {
			if (roomId != null && roomId != "") {
				if ((ownerId = oiService.getOwnerIdbyRoomId(Integer.valueOf(roomId))) == null) {
					return pageUtils;
				}
				ownerInfo.setOwnerId(ownerId);
			}
			pageUtils = oiService.getOwnerInfoList(ownerInfo, Integer.valueOf(currpage));
//			int i= 9/0; //测试AJAX请求下的异常页跳转--测试得知：AJAX（JSON）请求下，异常映射的视图无法被接收并跳转，只能先弄成JSON格式再通过JS脚本来进行跳转
		} catch (Exception e) {
			e.printStackTrace();
			throw new PMSException(e.getMessage()); 
		}
		return pageUtils;
	}
	
	/**
	 * 通过业主编号获取业主信息
	 * 如果ownerCode为空，则直接跳转页面
	 * @param ownerCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getownerinfobyownercode")
//	@ResponseBody
	public String getOwnerInfobyOwnerCode (String ownerCode, Model model) throws Exception {
//		System.out.println("测试");
		List<Company> ldcList = oiService.getAllCompany();
		if (ownerCode != null && ownerCode != "") {
			model.addAttribute("ownerInfo", oiService.getOwnerInfobyOwnerCode(ownerCode));
		} 
		model.addAttribute("ldcList", ldcList);
		return "jsp/homm/ownerinfo_oi";
	}
	
	/**
	 * 获取全部房地产经营公司信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getallcompany",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Company> getAllCompany () throws Exception {
		return oiService.getAllCompany();
	}
	
	/**
	 * 更新或添加业主的信息
	 * @param ownerInfo
	 * @param session
	 * @param attach
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/doownerinfo",method=RequestMethod.POST)
//	@ResponseBody
	public String doOwnerInfo(@ModelAttribute OwnerInfo ownerInfo,HttpServletRequest request, 
			          @RequestParam(value ="a_ownerPicname", required = false) MultipartFile attach) throws Exception{
		String fileName = null;
		File targetFile = null;
//		Map<String, String> resultMap = new HashMap<String, String>();
//		boolean flag = true;
		//获得文件上传路径
//		String upLoadPath = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); 
		String upLoadPath = request.getContextPath() + File.separator + "statics" + File.separator + "uploadfiles"; 
		request.setAttribute("ldcList", oiService.getAllCompany());//上传文件失败后，补全填写表单的页面的资料，以便于用户再次输入
		if(!attach.isEmpty()){
			//原文件名
			String oldFileName = attach.getOriginalFilename();
			//原文件后缀 
			String fileSuffix=FilenameUtils.getExtension(oldFileName);    
			int filesize = 500000;
			//上传大小不得超过 500k
			if(attach.getSize() > filesize){
//				resultMap.put("result", "filetoobig");
				request.setAttribute("uploadFileError", "上传大小不得超过 500k");
				return "jsp/homm/ownerinfo_oi";
			}
			//判断上传图片格式是否正确
			else if(fileSuffix.equalsIgnoreCase("jpg") || fileSuffix.equalsIgnoreCase("png") 
					|| fileSuffix.equalsIgnoreCase("jpeg") || fileSuffix.equalsIgnoreCase("pneg")){
				//修改文件名
				fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_HouseOwner."+fileSuffix;  
				//创建文件
				targetFile = new File(upLoadPath, fileName);  
				//不存在目录则创建目录
				if(!targetFile.exists()){  
					System.out.println(targetFile.getAbsolutePath());
					System.out.println(targetFile.mkdirs());
					  
				}  
				try {  
					//保存文件
					attach.transferTo(targetFile);  
				} catch (Exception e) { //此处不封装PMSException了，通过AJAX去提示用户
//					resultMap.put("result", "uploadfailed");
					e.printStackTrace();
					request.setAttribute("uploadFileError", "上传文件失败");
					return "jsp/homm/ownerinfo_oi";
				}  
			}else{
//				resultMap.put("result", "wrongformat");
				request.setAttribute("uploadFileError", "文件格式错误，须为：jpg、jpeg、png、pneg");
				return "jsp/homm/ownerinfo_oi";
			}
		}
		//正常则保存用户，否则返回报错提示
		ownerInfo.setOwnerPicname(fileName);
		try {
			//通过ownerId判断是要更新信息还是新增信息
			if (ownerInfo.getOwnerId() == null) { 
				oiService.addOwnerInfo(ownerInfo);
			} else {
				oiService.updateOwnerInfo(ownerInfo);
			}
//				resultMap.put("result", "success");
			request.setAttribute("success", "success");
		} catch (Exception e) {
//				resultMap.put("result", "dbfailed");
			e.printStackTrace();
			request.setAttribute("uploadFileError", "业主信息修改失败，请重试！");
			targetFile.delete(); // 上传数据库失败的话就要删除在服务器的文件了
		}
		return "jsp/homm/ownerinfo_oi";
	}
	
	/**
	 * 更新某个业主的状态
	 * @param ownerId
	 * @param ownerStatus
	 * @return
	 */
	@RequestMapping(value="/updateownerstatus",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object updateOwnerStatus(String ownerId, String ownerStatus) {
		Map<String, String> resultMap = new HashMap<String, String>();
		OwnerInfo oldOwner = new OwnerInfo();
		oldOwner.setOwnerId(Integer.valueOf(ownerId));
		try {
			OwnerInfo newOwner = (OwnerInfo) oiService.getOwnerInfoList(oldOwner, 1).getList().get(0);
			newOwner.setOwnerStatus(Integer.valueOf(ownerStatus));
			oiService.updateOwnerInfo(newOwner);
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
	/**
	 * 删除某个业主的信息**********（需要同时在业务层删除房产登记信息，房价表的ownerId和miId字段，以及入住表信息）
	 * @return
	 */
	@RequestMapping(value="/deleteownerinfo",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object deleteOwnerInfo(String ownerId) {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			oiService.deleteOwnerInfoById(Integer.valueOf(ownerId));
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
	/**
	 * 清除某个业主的照片  （没这种业务）
	 * @param ownerId
	 * @return
	 */
	@RequestMapping(value="/clearoipic",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> clearOiPic(String ownerId) {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			oiService.clearOwnerInfoPicnameById(Integer.valueOf(ownerId));
			resultMap.put("result", "success");
		}catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
/**************************此处开始家庭成员的业务******************************/
	
	/**
	 * 更新或添加家庭成员的信息
	 * @param familyMember
	 * @param request
	 * @param attach
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/dofm",method=RequestMethod.POST)
//	@ResponseBody
	public Object doFm(@ModelAttribute FamilyMembers familyMember,HttpServletRequest request, 
					    @RequestParam(value = "a_fmPicname", required = false) MultipartFile attach) throws UnsupportedEncodingException{
		String fileName = null;
		File targetFile = null;
		Integer status = null; //InfoVo信息对象的状态码
		String msgcontent = null; //InfoVo信息对象的提示信息
//		Map<String, String> resultMap = new HashMap<String, String>();
//		boolean flag = true;
		//获得文件上传路径
//		String upLoadPath = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); 
		String upLoadPath = request.getContextPath() + File.separator + "statics" + File.separator + "uploadfiles"; 
		if(!attach.isEmpty()){
			//原文件名
			String oldFileName = attach.getOriginalFilename();
			//原文件后缀 
			String fileSuffix=FilenameUtils.getExtension(oldFileName);    
			int filesize = 500000;
			//上传大小不得超过 500k
			if(attach.getSize() > filesize){
//				resultMap.put("result", "filetoobig");
//				request.setAttribute("InfoVo", new InfoVo(2,"上传大小不得超过 500k"));
				status = 2;
				msgcontent = "上传大小不得超过 500k";
				return "jsp/homm/ownerinfo_fm";
			}
			//判断上传图片格式是否正确
			else if(fileSuffix.equalsIgnoreCase("jpg") || fileSuffix.equalsIgnoreCase("png") 
					|| fileSuffix.equalsIgnoreCase("jpeg") || fileSuffix.equalsIgnoreCase("pneg")){
				//修改文件名
				fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_FamilyMembers."+fileSuffix;  
				//创建文件
				targetFile = new File(upLoadPath, fileName);  
				//不存在目录则创建目录
				if(!targetFile.exists()){  
					System.out.println(targetFile.getAbsolutePath());
					System.out.println(targetFile.mkdirs());
					  
				}  
				try {  
					//保存文件
					attach.transferTo(targetFile);  
				} catch (Exception e) { //此处不封装PMSException了，通过AJAX去提示用户
//					resultMap.put("result", "uploadfailed");
					e.printStackTrace();
//					request.setAttribute("InfoVo", new InfoVo(4, "上传文件失败"));
					status = 4;
					msgcontent = "上传文件失败";
					return "jsp/homm/ownerinfo_fm";
				}  
			}else{
//				resultMap.put("result", "wrongformat");
//				request.setAttribute("InfoVo", new InfoVo(3, "文件格式错误，须为：jpg、jpeg、png、pneg"));
				status = 3;
				msgcontent = "文件格式错误，须为：jpg、jpeg、png、pneg";
				return "jsp/homm/ownerinfo_fm";
			}
		}
		//正常则保存用户，否则返回报错提示
		familyMember.setFmPicname(fileName);
		try {
//			int i= 9/0;
			if (familyMember.getFmId() == null) {
				oiService.addFamilyMember(familyMember);
			} else {
				oiService.updateFamilyMemberById(familyMember);
			}
//			resultMap.put("result", "success");
//			request.setAttribute("InfoVo", new InfoVo(1, "操作成功"));
			status = 1;
			msgcontent = "操作成功";
		} catch (Exception e) {
			e.printStackTrace();
//			resultMap.put("result", "dbfailed");
//			request.setAttribute("InfoVo", new InfoVo(5, "成员信息修改失败，请重试！"));
			status = 5;
			msgcontent = "成员信息修改失败，请重试！";
			targetFile.delete(); // 上传数据库失败的话就要删除在服务器的文件了
		}
		String utfMsg = URLEncoder.encode(msgcontent,"utf-8");
		return "redirect:/homm/ownerinfo/getfamilymembers?ownerId=" + familyMember.getOwnerId() + "&status=" + status + "&msgcontent=" + utfMsg;
	}
	
	/**
	 * fmId为空时查找某个业主下的所有家庭成员
	 * fmId不为空时单个家庭成员 
	 */
	@RequestMapping(value="/getfamilymembers")
//	@ResponseBody
	public String getFamilyMembers(OwnerInfo oi, String fmId, Model model, @ModelAttribute("InfoVo") InfoVo infoVo) throws Exception {
		if (infoVo.getMsgcontent() != null) {
			String urlMsg = URLDecoder.decode(infoVo.getMsgcontent(),"utf-8");
			infoVo.setMsgcontent(urlMsg);
		}
		PageUtils pageContent = oiService.getOwnerInfoList(oi, 1);//获取业主全部信息
		model.addAttribute("ownerInfo", pageContent.getList().get(0));
		if (fmId != null && ! "".equals(fmId)) {
			List<FamilyMembers> fmListByFmId = oiService.getFamilyMembers(oi.getOwnerId(), Integer.valueOf(fmId));
			model.addAttribute("fmListByFmId", fmListByFmId);
//			model.addAttribute("isEmpty", true);//用来给页面判断是否要展示数据。当第一次进入页面或非修改家庭成员信息时都不用展示数据
		}
		List<FamilyMembers> fmList = oiService.getFamilyMembers(oi.getOwnerId(), null);
		model.addAttribute("fmList", fmList);
		return "jsp/homm/ownerinfo_fm";
	}
	
	/**
	 * 根据id删除具体的家庭成员信息
	 * @param OwnerId
	 * @return
	 */
	@RequestMapping(value="/deletefm",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> deleteFamilyMember(String fmId)  {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			int i = oiService.deleteFamilyMemberById(Integer.valueOf(fmId));
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
	/**
	 * 清除某个家庭成员的照片  （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	@RequestMapping(value="/clearfmpic",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> clearFmPic(String fmId){
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			oiService.clearFmPicnameById(Integer.valueOf(fmId));
			resultMap.put("result", "success");
		}catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
	/**************************此处结束家庭成员的业务******************************/
	
	/**************************此处开始房产登记信息的业务******************************/
	
	/**
	 * 更新或添加房产的信息
	 * @param ownerInfo
	 * @param session
	 * @param attach
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/doest",method=RequestMethod.POST)
//	@ResponseBody
	public String doEst(Estates estate) throws UnsupportedEncodingException{
//		Map<String, String> resultMap = new HashMap<String, String>();
		Integer status = null; //InfoVo信息对象的状态码
		String msgcontent = null; //InfoVo信息对象的提示信息
		try {
			if (estate.getEstId() == null) {
				oiService.addEstate(estate);
//				oiService.updateOwnerIdInRoom(estate.getOwnerId()); //移到service统一事务
			} else {
				oiService.updateEstateById(estate);
			}
//			resultMap.put("result", "success");
			status = 1;
			msgcontent = "操作成功！";
		} catch (Exception e) {
			e.printStackTrace();
//			resultMap.put("result", "failed");
			status = 2;
			msgcontent = "操作失败";
		}
		String utfMsg = URLEncoder.encode(msgcontent,"utf-8");
		return "redirect:/homm/ownerinfo/getestates?ownerId=" + estate.getOwnerId() + "&status=" + status + "&msgcontent=" + utfMsg;
	}
	
	/**
	 * 查找某个业主下的所有房产信息或单条房产信息（包含房间入住信息）
	 * 当estId为空时查业主下的所有房产信息，当estId不为空时查单条房产信息
	 */
	@RequestMapping(value="/getestates")
//	@ResponseBody
	public String getEstates(OwnerInfo oi, String estId, Model model, @ModelAttribute("InfoVo") InfoVo infoVo) throws Exception {
		if (infoVo.getMsgcontent() != null) {
			String urlMsg = URLDecoder.decode(infoVo.getMsgcontent(),"utf-8");
			infoVo.setMsgcontent(urlMsg);
		}
		PageUtils pageContent = oiService.getOwnerInfoList(oi, 1);//获取业主信息
		model.addAttribute("ownerInfo", pageContent.getList().get(0)); 
		model.addAttribute("consList", oiService.getAllConstruction());
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		rep.setCharacterEncoding("UTF-8"); // 还是乱码
//		rep.setContentType("application/json;charset=utf-8");
//		PrintWriter out = rep.getWriter();
		if (estId != null && !"".equals(estId)) {
			List<Estates> estListByEstId = oiService.getEstates(oi.getOwnerId(), Integer.valueOf(estId)); // 查找单个房产登记信息
			model.addAttribute("estListByEstId", estListByEstId);
			model.addAttribute("consList", oiService.getAllConstruction()); //查找全部房产小区信息
		}
		List<Estates> estList = oiService.getEstates(oi.getOwnerId(), null); // 查找全部房产登记信息
		for (Estates estates : estList) {
			estates.setRoom(oiService.getAllBuildingInfoByRoomId(estates.getRoomId())); //封装房产的全部区域信息，如：中东首座#1号楼#1单元#101室
			estates.setMi(oiService.getMoveInByEstId(estates.getEstId())); //封装各个房产的入住信息对象
		}
		model.addAttribute("estList", estList);
		return "jsp/homm/ownerinfo_est";
//		System.out.println(gson.toJson(estList));
//		System.out.println(JSONArray.toJSONString(estList));
//		out.print(gson.toJson(estList));
//		out.flush();
//		out.close();
//		return estList;
	}
	
	/**
	 *  根据id删除具体的房产信息
	 * @param OwnerId
	 * @return
	 */
	@RequestMapping(value="/deleteest",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> deleteEstate(Estates est)  {//参数封装了estId和roomId，mi为空
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			oiService.deleteEstateById(est);
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
	/**
	 *  逐层读取房产信息
	 * @param OwnerId
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value="/getallbuildingname",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getAllBuildingName(String consId,String bldId, String unitId){
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			if (consId != null) {
				return oiService.getAllBuildingByConsId(Integer.valueOf(consId));
			} else if (bldId != null) {
				return oiService.getAllUnitByBldId(Integer.valueOf(bldId));
			} else {
				return oiService.getAllRoomByUnitId(Integer.valueOf(unitId));
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", "failed");
		}
		return resultMap;
	}
	
	/**************************此处结束房产登记信息的业务******************************/
}
