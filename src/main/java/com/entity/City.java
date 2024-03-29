package com.entity;

/**
* @Description: 
* @author: 铭
* @date 2024年3月29日 上午8:17:07
*/

public class City {
	private Integer id;//主键
	private String name;//省市区名称
	private Integer parentid;//上级ID
	private String shortname;//简称
	private Integer leveltype;//级别:0,中国；1，省分；2，市；3，区、县
	private String citycode;//城市代码
	private String zipcode;//邮编
	private String lng;//经度
	private String lat;//纬度
	private String pinyin;//拼音
	private Integer status;//状态
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public Integer getLeveltype() {
		return leveltype;
	}
	public void setLeveltype(Integer leveltype) {
		this.leveltype = leveltype;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", parentid=" + parentid + ", shortname=" + shortname
				+ ", leveltype=" + leveltype + ", citycode=" + citycode + ", zipcode=" + zipcode + ", lng=" + lng
				+ ", lat=" + lat + ", pinyin=" + pinyin + ", status=" + status + "]";
	}
	public City(Integer id, String name, Integer parentid, String shortname, Integer leveltype, String citycode,
			String zipcode, String lng, String lat, String pinyin, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.shortname = shortname;
		this.leveltype = leveltype;
		this.citycode = citycode;
		this.zipcode = zipcode;
		this.lng = lng;
		this.lat = lat;
		this.pinyin = pinyin;
		this.status = status;
	}
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
