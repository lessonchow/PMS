package com.zhou.pms.dao.hopm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zhou.pms.po.hopm.Construction;

@Mapper
@Repository
public interface ConstructionMapper {
	
	/**
	 * 获取全部的楼盘信息
	 * @return
	 */
	public List<Construction> getAllConstruction() throws Exception;



}
