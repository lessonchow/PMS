package com.zhou.pms.dao.hopm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.po.hopm.Building;

@Mapper
@Repository
public interface BuildingMapper {

	/**
	 * 通过房产ID查所有楼宇
	 * @return
	 * @throws Exception
	 */
	public List<Building> getAllBuildingByConsId(@Param("consId") Integer consId) throws Exception;

}
