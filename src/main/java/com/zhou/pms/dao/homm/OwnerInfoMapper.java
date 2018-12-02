package com.zhou.pms.dao.homm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.commons.PageUtils;
import com.zhou.pms.po.homm.OwnerInfo;
import com.zhou.pms.po.hopm.Company;

@Mapper
@Repository
public interface OwnerInfoMapper {

	/**
	 * 获得全部业主信息的记录数或获取特定条件的记录数
	 * @return
	 */
	public long getOwnerInfoCount(OwnerInfo ownerInfo) throws Exception;

	
//	/**
//	 * 分页获取业主信息，*****可以不用方法的重载，此处是用来做测试*****
//	 * @param pageUtils
//	 * @return
//	 */
//	public List<OwnerInfo> getOwnerInfoList(PageUtils pageUtils) throws Exception;
	
	/**
	 * 分页获取全部业主信息或通过条件获取业主信息（信息条数达到一定数量才需要分页）
	 * @param ownerInfo
	 * @return
	 */
	public List<OwnerInfo> getOwnerInfoList(@Param("ownerInfo")OwnerInfo ownerInfo, @Param("pageUtils")PageUtils pageUtils) throws Exception;
	
	/**
	 * 通过业主编号ownerCode获取某个业主的信息
	 * @param ownerCode
	 * @return
	 * @throws Exception
	 */
	public OwnerInfo getOwnerInfobyOwnerCode(@Param("ownerCode") String ownerCode) throws Exception;
	
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
	public int deleteOwnerInfoById(@Param("id") Integer ownerId) throws Exception;
	
	/**
	 * 清除某个业主的照片  （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	public int clearOwnerInfoPicnameById(@Param("id") Integer ownerId) throws Exception;
	
	/**
	 * 增加新业主
	 */
	public int addNewOwnerInfo(OwnerInfo ownerInfo) throws Exception;
}
