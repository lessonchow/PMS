package com.zhou.pms.service.homm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhou.pms.commons.PageUtils;
import com.zhou.pms.dao.homm.EstatesMapper;
import com.zhou.pms.dao.homm.FamilyMembersMapper;
import com.zhou.pms.dao.homm.MoveInMapper;
import com.zhou.pms.dao.homm.OwnerInfoMapper;
import com.zhou.pms.dao.hopm.BldUnitMapper;
import com.zhou.pms.dao.hopm.BuildingMapper;
import com.zhou.pms.dao.hopm.CompanyMapper;
import com.zhou.pms.dao.hopm.ConstructionMapper;
import com.zhou.pms.dao.hopm.RoomMapper;
import com.zhou.pms.po.homm.Estates;
import com.zhou.pms.po.homm.FamilyMembers;
import com.zhou.pms.po.homm.MoveIn;
import com.zhou.pms.po.homm.OwnerInfo;
import com.zhou.pms.po.hopm.BldUnit;
import com.zhou.pms.po.hopm.Building;
import com.zhou.pms.po.hopm.Company;
import com.zhou.pms.po.hopm.Construction;
import com.zhou.pms.po.hopm.Room;
import com.zhou.pms.service.homm.IOwnerInfoService;

@Transactional
@Service
public class OwnerInfoService implements IOwnerInfoService{

	@Resource
	private EstatesMapper estMapper;
	@Resource
	private FamilyMembersMapper fmMapper;
	@Resource
	private OwnerInfoMapper oiMapper;
	@Resource
	private CompanyMapper comMapper;
	@Resource
	private RoomMapper rMapper;
	@Resource
	private ConstructionMapper conMapper;
	@Resource
	private BuildingMapper bldMapper;
	@Resource
	private BldUnitMapper buMapper;
	@Resource
	private MoveInMapper miMapper;
	
	/**
	 * 分页获取全部业主信息或通过条件获取业主信息（信息条数达到一定数量才需要分页）
	 * @return
	 * @throws Exception 
	 */
	@Override
	public PageUtils getOwnerInfoList(OwnerInfo ownerInfo, Integer currpage) throws Exception{
		long totalrecord = oiMapper.getOwnerInfoCount(ownerInfo);
		PageUtils pageUtils = null;
		//如果totalrecord小于5条记录数，currpage变回1
		if (totalrecord <= 5) {
			pageUtils = new PageUtils(1, 5, totalrecord, 2);
		} else {
			pageUtils = new PageUtils(currpage, 5, totalrecord, 2);
		}
//		System.out.println(pageUtils);
//		System.out.println(ownerInfo);
		//如果找不到业主信息，底层会返回一个空的List，不是null。这个其实跟完全没有封装时的做法是一样的
		List<OwnerInfo> oiList= oiMapper.getOwnerInfoList(ownerInfo, pageUtils); 
		for (OwnerInfo oi : oiList) {
			oi.setFmCount(fmMapper.getFmCount(oi.getOwnerId()));
			oi.setEstCount(estMapper.getEstCount(oi.getOwnerId()));
		}
		pageUtils.setList(oiList);
		return pageUtils;
	}
	
	/**
	 * 通过房间号获得对应的业主id
	 * @param RoomId
	 * @return
	 */
	@Override
	public Integer getOwnerIdbyRoomId(Integer roomId) throws Exception {
		return rMapper.getOwnerIdbyRoomId(roomId);
	}
	
	/**
	 * 通过业主编号ownerCode获取某个业主的信息
	 * @param ownerCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public OwnerInfo getOwnerInfobyOwnerCode(String ownerCode) throws Exception {
		OwnerInfo oi = oiMapper.getOwnerInfobyOwnerCode(ownerCode);
//		oi.setLdcList(oiMapper.getAllCompany());
		return oi;
	}
	
	/**
	 * 获取全部房地产经营公司信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Company> getAllCompany() throws Exception {
		return comMapper.getAllCompany();
	}
	
	/**
	 * 更新相应业主的信息
	 * @param ownerInfo
	 * @return
	 */
	@Override
	public int updateOwnerInfo(OwnerInfo ownerInfo) throws Exception {
		return oiMapper.updateOwnerInfo(ownerInfo);
	}
	
	/**
	 * 根据id删除具体的业主信息
	 * @param OwnerId
	 * @return
	 */
	@Override
	public int deleteOwnerInfoById(Integer OwnerId) throws Exception {
		return oiMapper.deleteOwnerInfoById(OwnerId);
	}
	
	/**
	 * 清除某个业主的照片 （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	@Override
	public int clearOwnerInfoPicnameById(Integer ownerId) throws Exception {
		return oiMapper.clearOwnerInfoPicnameById(ownerId);
	}
	
	/**
	 * 增加新业主
	 */
	@Override
	public int addOwnerInfo(OwnerInfo ownerInfo) throws Exception {
		return oiMapper.addNewOwnerInfo(ownerInfo);
	}
	
	/**************************此处开始家庭成员的业务******************************/
	
	/**
	 * 新增某个业主的家庭成员
	 */
	@Override
	public int addFamilyMember(FamilyMembers FamilyMember) throws Exception {
		return fmMapper.addNewFamilyMember(FamilyMember);
	}
	
	/**
	 * fmId为空时查找某个业主下的所有家庭成员
	 * fmId不为空时单个家庭成员 
	 */
	@Override
	public List<FamilyMembers> getFamilyMembers(Integer ownerId, Integer fmId) throws Exception {
		return fmMapper.getFamilyMembers(ownerId, fmId);
	}
	
	/**
	 * 更新相应家庭成员的信息
	 * @param ownerInfo
	 * @return
	 */
	@Override
	public int updateFamilyMemberById(FamilyMembers FamilyMember) throws Exception {
		return fmMapper.updateFamilyMemberById(FamilyMember);
	}
	
	/**
	 * 根据id删除具体的家庭成员信息
	 * @param OwnerId
	 * @return
	 */
	@Override
	public int deleteFamilyMemberById(Integer fmId) throws Exception {
		return fmMapper.deleteFamilyMemberById(fmId);
	}
	
	/**
	 * 清除某个家庭成员的照片  （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	@Override
	public int clearFmPicnameById(Integer fmId) throws Exception {
		return fmMapper.clearFmPicnameById(fmId);
	}
	
	/**************************此处结束家庭成员的业务******************************/
	
	/**************************此处开始房产登记信息的业务******************************/
	
	/**
	 * 新增某个业主的房产信息
	 */
	@Override
	public void addEstate(Estates estate) throws Exception {
		int i = 0;
		i = estMapper.addNewEstate(estate);
		System.err.println(estate.getEstId());
		i = rMapper.updateOwnerIdMiIdInRoom(estate);
		if (i == 0) { //一般不这么判断，因为id都是控制好一定存在的，所以增修方法一般出异常才会没有返回值
			throw new RuntimeException("新增房产信息失败！"); //如果某一步失败，则全部回滚
		}
	}
	
	/**
	 * 查找某个业主下的所有房产信息或单条房产信息（包含房间入住信息）
	 * 当estId为空时查业主下的所有房产信息，当estId不为空时查单条房产信息
	 */
	@Override
	public List<Estates> getEstates(Integer ownerId, Integer estId) throws Exception {
		return estMapper.getEstates(ownerId, estId);
	}
	
	/**
	 * 更新相应房产的信息
	 * @param ownerInfo
	 * @return
	 */
	@Override
	public int updateEstateById(Estates estate) throws Exception {
		return estMapper.updateEstateById(estate);
	}
	
	/**
	 * 根据id删除具体的房产信息
	 * @param estId
	 * @return
	 */
	@Override
	public void deleteEstateById(Estates est) throws Exception { //参数封装了estId和roomId，mi为空
//		int i = 0;
//		est.setMi(miMapper.getMoveInByEstId(est.getEstId())); //这里mi本来就是null
		estMapper.deleteEstateById(est.getEstId());
		miMapper.deleteMoveInByEstId(est.getEstId());
		est.setEstId(null); // 把房产ID去掉
		rMapper.updateOwnerIdMiIdInRoom(est);
		
//		if (i == 0) { 
//			throw new RuntimeException("删除失败！");//如果某一步失败，则全部回滚
//		}
	}
	
	/**
	 * 获取全部房产名字
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Construction> getAllConstruction() throws Exception {
		return conMapper.getAllConstruction();
	}
	
	/**
	 * 通过房产ID获取全部楼宇
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Building> getAllBuildingByConsId(Integer consId) throws Exception {
		return bldMapper.getAllBuildingByConsId(consId);
	}
	
	/**
	 * 通过楼宇ID获取全部单元
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BldUnit> getAllUnitByBldId(Integer bldId) throws Exception {
		return buMapper.getAllUnitByBldId(bldId);
	}
	
	/**
	 * 通过单元ID获取全部房间
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Room> getAllRoomByUnitId(Integer unitId) throws Exception {
		return rMapper.getAllRoomByUnitId(unitId);
	}
	
	/**
	 * 通过房间ID获取全部房产信息
	 * @param RoomId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Room getAllBuildingInfoByRoomId(Integer RoomId) throws Exception {
		return rMapper.getAllBuildingInfoByRoomId(RoomId);
	}
	
//	/**
//	 * 为添加房产登记信息和删除房产登记信息而更改tb_room表的owner_id字段
//	 * @param ownerId
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	public int updateOwnerIdInRoom(Integer ownerId) throws Exception {
//		return rMapper.updateOwnerIdInRoom(ownerId);
//	}
	
	/**
	 * 查找某个房产信息下的入住信息
	 * @param estId
	 * @return
	 * @throws Exception
	 */
	@Override
	public MoveIn getMoveInByEstId(Integer estId) throws Exception {
		return miMapper.getMoveInByEstId(estId);
	}
	
	/**************************此处结束房产登记信息的业务******************************/
	
}
