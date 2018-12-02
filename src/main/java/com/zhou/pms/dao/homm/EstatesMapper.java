package com.zhou.pms.dao.homm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.po.homm.Estates;
import com.zhou.pms.po.homm.FamilyMembers;
import com.zhou.pms.po.homm.OwnerInfo;

@Mapper
@Repository
public interface EstatesMapper {

	/**
	 * 新增某个业主的房产信息
	 */
	public int addNewEstate(Estates estate) throws Exception;
	
	/**
	 * 查找某个业主下的所有房产信息或单条房产信息（包含房间入住信息）
	 * 当estId为空时查业主下的所有房产信息，当estId不为空时查单条房产信息
	 */
	public List<Estates> getEstates(@Param("ownerId") Integer ownerId, @Param("estId") Integer estId) throws Exception;
	
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
	public int deleteEstateById(@Param("id") Integer estId) throws Exception;
	

	/**
	 * 获取相应业主的房产数量
	 * @param OwnerId
	 * @return
	 */
	public int getEstCount(@Param("id") Integer ownerId) throws Exception;
	
	
}
