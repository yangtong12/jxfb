package com.nchu.library.entity;

import java.util.Date;

public class ActivityInfo {
	private Integer activityId;
	private int activityCategory;
	private Date activityBgntm;
	private Date activityEndtm;
	private Integer canorderNum;
	private String beginNo;
	private String openGrade;
	private int leftorderNum;
	private int activityStatus;
	private String activityName;
	private SystemSet systemSet;
	private Date nextactivityBgntm;
	private int nextcanorderNum;
	public Date getNextactivityBgntm() {
		return nextactivityBgntm;
	}
	public void setNextactivityBgntm(Date nextactivityBgntm) {
		this.nextactivityBgntm = nextactivityBgntm;
	}
	public int getNextcanorderNum() {
		return nextcanorderNum;
	}
	public void setNextcanorderNum(int nextcanorderNum) {
		this.nextcanorderNum = nextcanorderNum;
	}
	public SystemSet getSystemSet() {
		return systemSet;
	}
	public void setSystemSet(SystemSet systemSet) {
		this.systemSet = systemSet;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public int getActivityCategory() {
		return activityCategory;
	}
	public void setActivityCategory(int activityCategory) {
		this.activityCategory = activityCategory;
	}
	public Date getActivityBgntm() {
		return activityBgntm;
	}
	public void setActivityBgntm(Date activityBgntm) {
		this.activityBgntm = activityBgntm;
	}
	public Date getActivityEndtm() {
		return activityEndtm;
	}
	public void setActivityEndtm(Date activityEndtm) {
		this.activityEndtm = activityEndtm;
	}
	public Integer getCanorderNum() {
		return canorderNum;
	}
	public void setCanorderNum(Integer canorderNum) {
		this.canorderNum = canorderNum;
	}
	public String getBeginNo() {
		return beginNo;
	}
	public void setBeginNo(String beginNo) {
		this.beginNo = beginNo;
	}
	public String getOpenGrade() {
		return openGrade;
	}
	public void setOpenGrade(String openGrade) {
		this.openGrade = openGrade;
	}
	
	public int getLeftorderNum() {
		return leftorderNum;
	}
	public void setLeftorderNum(int leftorderNum) {
		this.leftorderNum = leftorderNum;
	}
	public int getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(int activityStatus) {
		this.activityStatus = activityStatus;
	}
	
	

}
