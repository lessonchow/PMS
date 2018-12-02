package com.zhou.pms.po.hopm;

public class Room {

	private Integer roomId;
	private TbRoomCharacter tbRoomCharacter;
	private TbRoomProperty tbRoomProperty;
	private TbRoomType tbRoomType;
	private TbRoomFunction tbRoomFunction;
	private TbRoomDirect tbRoomDirect;
	private TbRoomDecorate tbRoomDecorate;
	private int floorNum;
	private String roomCode;
	private String roomName;
	private Float roomBuildArea;
	private Float roomUseArea;
	private Float loftArea;
	private Float storeArea;
	private Float carspaceArea;
	private Float carportArea;
	private String roomRent;
	private String roomRemark;
	private Float roomLength;
	private Float roomWidth;
	private Integer roomDistrictId;
	private Integer unitId;
	private String roomIdRelation;
	
	private Integer miId;
	private Integer estId;
	
	private BldUnit bldUnit;
	private Building building;
	private Construction construction;
	private Company company;
	private String estFullName;
	
	public String getEstFullName() {
		if (construction == null || building == null || bldUnit == null) {
			return null;
		} else {
			return construction.getConsName() + "#" + building.getBldName() + "#" + bldUnit.getUnitName() + "#" + roomName;
		}
	}
	public void setEstFullName(String estFullName) {
		this.estFullName = estFullName;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public TbRoomCharacter getTbRoomCharacter() {
		return tbRoomCharacter;
	}
	public void setTbRoomCharacter(TbRoomCharacter tbRoomCharacter) {
		this.tbRoomCharacter = tbRoomCharacter;
	}
	public TbRoomProperty getTbRoomProperty() {
		return tbRoomProperty;
	}
	public void setTbRoomProperty(TbRoomProperty tbRoomProperty) {
		this.tbRoomProperty = tbRoomProperty;
	}
	public TbRoomType getTbRoomType() {
		return tbRoomType;
	}
	public void setTbRoomType(TbRoomType tbRoomType) {
		this.tbRoomType = tbRoomType;
	}
	public TbRoomFunction getTbRoomFunction() {
		return tbRoomFunction;
	}
	public void setTbRoomFunction(TbRoomFunction tbRoomFunction) {
		this.tbRoomFunction = tbRoomFunction;
	}
	public TbRoomDirect getTbRoomDirect() {
		return tbRoomDirect;
	}
	public void setTbRoomDirect(TbRoomDirect tbRoomDirect) {
		this.tbRoomDirect = tbRoomDirect;
	}
	public TbRoomDecorate getTbRoomDecorate() {
		return tbRoomDecorate;
	}
	public void setTbRoomDecorate(TbRoomDecorate tbRoomDecorate) {
		this.tbRoomDecorate = tbRoomDecorate;
	}
	public int getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Float getRoomBuildArea() {
		return roomBuildArea;
	}
	public void setRoomBuildArea(Float roomBuildArea) {
		this.roomBuildArea = roomBuildArea;
	}
	public Float getRoomUseArea() {
		return roomUseArea;
	}
	public void setRoomUseArea(Float roomUseArea) {
		this.roomUseArea = roomUseArea;
	}
	public Float getLoftArea() {
		return loftArea;
	}
	public void setLoftArea(Float loftArea) {
		this.loftArea = loftArea;
	}
	public Float getStoreArea() {
		return storeArea;
	}
	public void setStoreArea(Float storeArea) {
		this.storeArea = storeArea;
	}
	public Float getCarspaceArea() {
		return carspaceArea;
	}
	public void setCarspaceArea(Float carspaceArea) {
		this.carspaceArea = carspaceArea;
	}
	public Float getCarportArea() {
		return carportArea;
	}
	public void setCarportArea(Float carportArea) {
		this.carportArea = carportArea;
	}
	public String getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(String roomRent) {
		this.roomRent = roomRent;
	}
	public String getRoomRemark() {
		return roomRemark;
	}
	public void setRoomRemark(String roomRemark) {
		this.roomRemark = roomRemark;
	}
	public Float getRoomLength() {
		return roomLength;
	}
	public void setRoomLength(Float roomLength) {
		this.roomLength = roomLength;
	}
	public Float getRoomWidth() {
		return roomWidth;
	}
	public void setRoomWidth(Float roomWidth) {
		this.roomWidth = roomWidth;
	}
	public Integer getRoomDistrictId() {
		return roomDistrictId;
	}
	public void setRoomDistrictId(Integer roomDistrictId) {
		this.roomDistrictId = roomDistrictId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getRoomIdRelation() {
		return roomIdRelation;
	}
	public void setRoomIdRelation(String roomIdRelation) {
		this.roomIdRelation = roomIdRelation;
	}
	public Integer getMiId() {
		return miId;
	}
	public void setMiId(Integer miId) {
		this.miId = miId;
	}
	public Integer getEstId() {
		return estId;
	}
	public void setEstId(Integer estId) {
		this.estId = estId;
	}
	public BldUnit getBldUnit() {
		return bldUnit;
	}
	public void setBldUnit(BldUnit bldUnit) {
		this.bldUnit = bldUnit;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public Construction getConstruction() {
		return construction;
	}
	public void setConstruction(Construction construction) {
		this.construction = construction;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
