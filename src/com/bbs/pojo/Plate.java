package com.bbs.pojo;

public class Plate {
	private String plateTitle;
	private String plateMessage;
	private Integer isEnable;
	
	
	
	
	
	
	
	
	public Plate() {
		super();
	}
	public Plate(String plateTitle, String plateMessage, Integer isEnable) {
		super();
		this.plateTitle = plateTitle;
		this.plateMessage = plateMessage;
		this.isEnable = isEnable;
	}
	public String getPlateTitle() {
		return plateTitle;
	}
	public void setPlateTitle(String plateTitle) {
		this.plateTitle = plateTitle;
	}
	public String getPlateMessage() {
		return plateMessage;
	}
	public void setPlateMessage(String plateMessage) {
		this.plateMessage = plateMessage;
	}
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	
}
