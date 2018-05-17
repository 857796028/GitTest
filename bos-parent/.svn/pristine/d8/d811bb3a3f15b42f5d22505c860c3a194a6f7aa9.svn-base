package com.itheima.bos.domain;

/**
 * 分区
 */

public class Subarea implements java.io.Serializable {

	// Fields

	private String id;
	private Region region;  //分区对应的区域
	private Decidedzoom decidedzoom;
	private String addresskey;
	private String startnum;
	private String endnum;
	private String single;
	private String position;
	
	//是为了在增加定区时,由于在页面修改了subareaid,取不到值,于是添加方法
	public String getSubareaid(){
		return id;
	}

	// Constructors

	/** default constructor */
	public Subarea() {
	}

	/** minimal constructor */
	public Subarea(String id) {
		this.id = id;
	}

	/** full constructor */
	public Subarea(String id, Region region, Decidedzoom decidedzoom, String addresskey, String startnum, String endnum,
			String single, String position) {
		this.id = id;
		this.region = region;
		this.decidedzoom = decidedzoom;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Decidedzoom getDecidedzoom() {
		return this.decidedzoom;
	}

	public void setDecidedzoom(Decidedzoom decidedzoom) {
		this.decidedzoom = decidedzoom;
	}

	public String getAddresskey() {
		return this.addresskey;
	}

	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	public String getStartnum() {
		return this.startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	public String getEndnum() {
		return this.endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	public String getSingle() {
		return this.single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}