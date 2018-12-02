package com.zhou.pms.dao.hopm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.commons.PageUtils;
import com.zhou.pms.po.homm.OwnerInfo;
import com.zhou.pms.po.hopm.Company;

@Mapper
@Repository
public interface CompanyMapper {
	/**
	 * 获取全部房地产经营公司信息
	 * @return
	 * @throws Exception
	 */
	public List<Company> getAllCompany() throws Exception;

}