package com.zhou.pms.dao.hopm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.commons.PageUtils;
import com.zhou.pms.po.homm.OwnerInfo;
import com.zhou.pms.po.hopm.BldUnit;
import com.zhou.pms.po.hopm.Company;
import com.zhou.pms.po.hopm.Room;

@Mapper
@Repository
public interface BldUnitMapper {

	/**
	 * 通过单元ID查所有单元
	 * @return
	 * @throws Exception
	 */
	public List<BldUnit> getAllUnitByBldId(@Param("bldId") Integer bldId) throws Exception;

}
