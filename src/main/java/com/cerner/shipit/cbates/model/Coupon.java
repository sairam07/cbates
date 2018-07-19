package com.cerner.shipit.cbates.model;

import java.util.Date;

public class Coupon implements Comparable<Coupon>{

	private String couponName;
	private String url;
	private int workedCount;
	private int notWorkedCount;
	private Date lastUpdated;
	private Boolean lastUpdatedStatus;

	public Coupon() {}
	public Coupon(String couponName, String url) {
		super();
		this.couponName = couponName;
		this.url = url;
	}
	
	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWorkedCount() {
		return workedCount;
	}

	public void setWorkedCount(int workedCount) {
		this.workedCount = workedCount;
	}

	public int getNotWorkedCount() {
		return notWorkedCount;
	}

	public void setNotWorkedCount(int notWorkedCount) {
		this.notWorkedCount = notWorkedCount;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Boolean getLastUpdatedStatus() {
		return lastUpdatedStatus;
	}

	public void setLastUpdatedStatus(Boolean lastUpdatedStatus) {
		this.lastUpdatedStatus = lastUpdatedStatus;
	}

	@Override
	public int compareTo(Coupon o) {
		// TODO Auto-generated method stub
		return (o.getWorkedCount() - this.workedCount );
	}

}
