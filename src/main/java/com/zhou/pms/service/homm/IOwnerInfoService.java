package com.zhou.pms.service.homm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhou.pms.commons.PageUtils;
import com.zhou.pms.po.homm.Estates;
import com.zhou.pms.po.homm.FamilyMembers;
import com.zhou.pms.po.homm.MoveIn;
import com.zhou.pms.po.homm.OwnerInfo;
import com.zhou.pms.po.hopm.BldUnit;
import com.zhou.pms.po.hopm.Building;
import com.zhou.pms.po.hopm.Company;
import com.zhou.pms.po.hopm.Construction;
import com.zhou.pms.po.hopm.Room;

public interface IOwnerInfoService {

	/**
	 * 当入参为空时分页获取全部业主信息 
	 * 当入参不为空时通过条件获取业主信息（信息条数达到一定数量才需要分页）
	 * @return
	 * @throws Exception 
	 */
	public PageUtils getOwnerInfoList(OwnerInfo ownerInfo, Integer currpage) throws Exception;
	
	/**
	 * 通过房间号获得对应的业主id
	 * @param RoomId
	 * @return
	 */
	public Integer getOwnerIdbyRoomId(Integer roomId) throws Exception;
	
	/**
	 * 通过业主编号ownerCode获取某个业主的信息
	 * @param ownerCode
	 * @return
	 * @throws Exception
	 */
	public OwnerInfo getOwnerInfobyOwnerCode(String ownerCode) throws Exception;
	
	/**
	 * 获取全部房地产经营公司信息
	 * @return
	 * @throws Exception
	 */
	public List<Company> getAllCompany() throws Exception;
	
	/**
	 * 更新相应业主的信息
	 * @param ownerInfo
	 * @return
	 */
	public int updateOwnerInfo(OwnerInfo ownerInfo) throws Exception;
	
	/**
	 * 根据id删除具体的业主信息
	 * @param OwnerId
	 * @return
	 */
	public int deleteOwnerInfoById(Integer ownerId) throws Exception;
	
	/**
	 * 清除某个业主的照片  （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	public int clearOwnerInfoPicnameById(Integer ownerId) throws Exception;
	
	/**
	 * 增加新业主
	 */
	public int addOwnerInfo(OwnerInfo ownerInfo) throws Exception;
	
	/**************************此处开始家庭成员的业务******************************/
	
	/**
	 * 新增某个业主的家庭成员
	 */
	public int addFamilyMember(FamilyMembers FamilyMember) throws Exception;
	
	/**
	 * fmId为空时查找某个业主下的所有家庭成员
	 * fmId不为空时单个家庭成员 
	 */
	public List<FamilyMembers> getFamilyMembers(Integer ownerId, Integer fmId) throws Exception;
	
	/**
	 * 更新相应家庭成员的信息
	 * @param ownerInfo
	 * @return
	 */
	public int updateFamilyMemberById(FamilyMembers FamilyMember) throws Exception;
	
	/**
	 * 根据id删除具体的家庭成员信息
	 * @param OwnerId
	 * @return
	 */
	public int deleteFamilyMemberById(Integer fmId) throws Exception;
	
	/**
	 * 清除某个家庭成员的照片  （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	public int clearFmPicnameById(Integer fmId) throws Exception;
	
	/**************************此处结束家庭成员的业务******************************/
	
	/**************************此处开始房产登记信息的业务******************************/
	
	/**
	 * 新增某个业主的房产信息
	 */
	public void addEstate(Estates estate) throws Exception;
	
	/**
	 * 查找某个业主下的所有房产信息或单条房产信息（包含房间入住信息）
	 * 当estId为空时查业主下的所有房产信息，当estId不为空时查单条房产信息
	 */
	public List<Estates> getEstates(Integer ownerId, Integer estId) throws Exception;
	
	/**
	 * 更新相应房产的信息
	 * @param ownerInfo
	 * @return
	 */
	public int updateEstateById(Estates estate) throws Exception;
	
	/**
	 * 根据id删除具体的房产信息
	 * @param estId
	 * @return
	 */
	public void deleteEstateById(Estates est) throws Exception;

	/**
	 * 获取全部房产名字
	 * @return
	 * @throws Exception
	 */
	public List<Construction> getAllConstruction() throws Exception;
	
	/**
	 * 通过房产ID获取全部楼宇
	 * @return
	 * @throws Exception
	 */
	public List<Building> getAllBuildingByConsId(Integer consId) throws Exception;
	
	/**
	 * 通过楼宇ID获取全部单元
	 * @return
	 * @throws Exception
	 */
	public List<BldUnit> getAllUnitByBldId(Integer bldId) throws Exception;
	
	/**
	 * 通过单元ID获取全部房间
	 * @return
	 * @throws Exception
	 */
	public List<Room> getAllRoomByUnitId(Integer unitId) throws Exception;
	
	/**
	 * 通过房间ID获取全部房产信息
	 * @param RoomId
	 * @return
	 * @throws Exception
	 */
	public Room getAllBuildingInfoByRoomId(Integer RoomId) throws Exception;
	
//	/**
//	 * 为添加房产登记信息和删除房产登记信息而更改tb_room表的owner_id字段
//	 * @param ownerId
//	 * @return
//	 * @throws Exception
//	 */
//	public int updateOwnerIdInRoom(Integer ownerId) throws Exception;
	
	/**
	 * 查找某个房产信息下的入住信息
	 * @param estId
	 * @return
	 * @throws Exception
	 */
	public MoveIn getMoveInByEstId(Integer estId) throws Exception;
}
