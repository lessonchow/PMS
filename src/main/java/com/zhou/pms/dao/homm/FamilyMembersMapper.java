package com.zhou.pms.dao.homm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.po.homm.FamilyMembers;
import com.zhou.pms.po.homm.OwnerInfo;

@Mapper
@Repository
public interface FamilyMembersMapper {

	/**
	 * 新增某个业主的家庭成员
	 */
	public int addNewFamilyMember(FamilyMembers FamilyMember) throws Exception;
	
	/**
	 * fmId为空时查找某个业主下的所有家庭成员
	 * fmId不为空时单个家庭成员 
	 */
	public List<FamilyMembers> getFamilyMembers(@Param("ownerId") Integer ownerId, @Param("fmId") Integer fmId) throws Exception;
	
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
	public int deleteFamilyMemberById(@Param("id") Integer fmId) throws Exception;
	
	/**
	 * 清除某个家庭成员的照片  （没这种业务）
	 * @param OwnerId
	 * @return
	 */
	public int clearFmPicnameById(@Param("id") Integer fmId) throws Exception;
	
	/**
	 * 获取相应业主的家庭成员数量
	 * @param OwnerId
	 * @return
	 */
	public int getFmCount(@Param("id") Integer ownerId) throws Exception;
	
	
}
