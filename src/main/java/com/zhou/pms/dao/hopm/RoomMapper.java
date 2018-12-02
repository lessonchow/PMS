package com.zhou.pms.dao.hopm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhou.pms.po.homm.Estates;
import com.zhou.pms.po.homm.MoveIn;
import com.zhou.pms.po.hopm.Room;

@Mapper
@Repository
public interface RoomMapper {

	/**
	 * 通过房间号获得对应的业主id
	 * @param RoomId
	 * @return
	 */
	public Integer getOwnerIdbyRoomId(@Param("id") Integer RoomId) throws Exception;
	
	/**
	 * 通过联表查询全部房产详细信息和经营公司信息
	 * @param RoomId 房间ID
	 * @return
	 * @throws Exception
	 */
	public Room getAllBuildingInfoByRoomId(@Param("roomId") Integer RoomId) throws Exception;
	
	/**
	 * 通过单元ID查所有房间
	 * @return
	 * @throws Exception
	 */
	public List<Room> getAllRoomByUnitId(@Param("unitId") Integer unitId) throws Exception;
	
	/**
	 * 为添加房产登记信息和删除房产登记信息而更改tb_room表的est_id和mi_id字段。这个方法里mi_id永远是null，所以只有在删除房产时才有作用
	 * *******这是非常规传参做法，常规应该传Room对象，更新全部字段
	 * @param ownerId
	 * @return
	 * @throws Exception
	 */
	public int updateOwnerIdMiIdInRoom(Estates est) throws Exception;
	
	/**
	 * 为删除房产登记信息而更改tb_room表的mi_id字段
	 * @param ownerId
	 * @return
	 * @throws Exception
	 */
//	public int updateMiIdInRoom(MoveIn mi) throws Exception;

}
