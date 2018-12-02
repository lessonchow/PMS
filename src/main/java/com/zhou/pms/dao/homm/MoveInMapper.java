package com.zhou.pms.dao.homm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.po.homm.MoveIn;

@Mapper
@Repository
public interface MoveInMapper {

	/**
	 * 查找某个房产信息下的入住信息
	 * @param estId
	 * @return
	 * @throws Exception
	 */
	public MoveIn getMoveInByEstId(@Param("estId") Integer estId) throws Exception;
	
	/**
	 * 根据房产登记信息ID删除入住信息
	 * @param estId
	 * @return
	 * @throws Exception
	 */
	public int deleteMoveInByEstId(@Param("estId") Integer estId) throws Exception;
}
