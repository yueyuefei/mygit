package com.rockontrol.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * WeatherStationInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "weather_station_info", catalog = "env")
public class WeatherStationInfo implements java.io.Serializable {

	// Fields

	private String phone;
	private Timestamp buildTime;
	private String toucher;
	private String note;
	private String content;
	private String remark;
	private String imageUrl;
	private String ECode;
	
	private Integer id;
	private String mn;
	private String address;//显示名称
	private String longitude;
	private String latitude;
	private String builder;//所属城市
	private String locationName;//详细地理位置
	private String townName;//站长、所有人
	private String type; //0自主，2国标，4桌面，6移动
	private String stationType;   //1有红外功能
	private String state;//1启用，0未启用
	private String ps;//密码
	private String inOut; //0室外 1室内
	private String geohash;
	private String cityName,cityPm25;//当前所属城市名称，所属城市pm25
	private String wd,fl,sd,weather;//所属城市，温度、风力、湿度,天气
	private String ownWd,ownSd;//设备温度、湿度
	private String publishDate;//发布时间
	private String isVisible;//0可见，1需申请，2不可见
	private String searchable;//是否可以被搜索到  0可以 1不可以，默认null可以
	private String remindable;//是否提醒 0不提醒 1提醒，默认null不提醒
	private String isAttention;//是否关注 1关注,0未关注,-1申请中
	private Long attentionCount;//总关注数
	private Double distance;//与当前位置距离
	//基站基础信息
	private float pm25;//每10分钟上报一次数据
	private float otherPm25;//对比基站/城市pm25
	private String otherName;//对比基站/城市名称
	
	private Map<String,String> map;
	
	//基站是否断线，0在线，1掉线
	private int deviceState;
	//是否已经开始上传数据,0 已经开始,1 没有开始
	private Integer dataUpload;
	
	//查看总数
	private int viewCount;
	//点赞总数
	private int praiseCount;
	private int isPraise;//0,未点赞评论;1已点赞;2已踩
	//踩总数
	private int unlikeCount;
	//评论总数
	private int commentCount;
	//分享总数
	private int shareCount;
	private int score;//设备检测分数
	private Long lastUpdateTime;//设备数据最后更新时间
	
	//设备详细数据及6天历史数据
	private Map<String,Object> dataDetail;
	
	
	//设置参数信息
	private Map<String,String> parameterMap;
	
	// Constructors

	/** default constructor */
	public WeatherStationInfo() {
	}

	/** minimal constructor */
	public WeatherStationInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public WeatherStationInfo(Integer id, String mn, String phone,
			String address, String longitude, String latitude, String builder,
			Timestamp buildTime, String toucher, String note, String townName,
			String ps, String type, String state) {
		this.id = id;
		this.mn = mn;
		this.phone = phone;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.builder = builder;
		this.buildTime = buildTime;
		this.toucher = toucher;
		this.note = note;
		this.townName = townName;
		this.ps = ps;
		this.type = type;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "mn", length = 20)
	public String getMn() {
		return this.mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "longitude", length = 50)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
	@Column(name = "latitude", length = 50)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "builder", length = 100)
	public String getBuilder() {
		return this.builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	@Column(name = "build_time", length = 19)
	public Timestamp getBuildTime() {
		return this.buildTime;
	}

	public void setBuildTime(Timestamp buildTime) {
		this.buildTime = buildTime;
	}

	@Column(name = "toucher", length = 100)
	public String getToucher() {
		return this.toucher;
	}

	public void setToucher(String toucher) {
		this.toucher = toucher;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "town_name", length = 100)
	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	@Column(name = "ps", length = 6)
	public String getPs() {
		return this.ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	@Column(name = "type", length = 1)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "state", length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "in_out")
	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
	
	@Column(name = "e_code")
	public String getECode() {
		return ECode;
	}

	public void setECode(String eCode) {
		ECode = eCode;
	}
	
	@Column(name="geohash")
	public String getGeohash() {
		return geohash;
	}

	public void setGeohash(String geohash) {
		this.geohash = geohash;
	}	
	
	@Transient
	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}

	@Transient
	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	@Transient
	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}
	
	@Transient
	public float getOtherPm25() {
		return otherPm25;
	}

	public void setOtherPm25(float otherPm25) {
		this.otherPm25 = otherPm25;
	}

	@Transient
	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	
	@Transient
	public float getPm25() {
		return pm25;
	}

	public void setPm25(float pm25) {
		if(pm25>500){
			pm25=500;
		}
		this.pm25 = pm25;
	}
	
	@Transient
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Transient
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Transient
	public String getOwnWd() {
		return ownWd;
	}

	public void setOwnWd(String ownWd) {
		this.ownWd = ownWd;
	}

	@Transient
	public String getOwnSd() {
		return ownSd;
	}

	public void setOwnSd(String ownSd) {
		this.ownSd = ownSd;
	}

	@Transient
	public String getIsAttention() {
		return isAttention;
	}

	public void setIsAttention(String isAttention) {
		this.isAttention = isAttention;
	}

	@Transient
	public Long getAttentionCount() {
		return attentionCount;
	}

	public void setAttentionCount(Long attentionCount) {
		this.attentionCount = attentionCount;
	}

	@Transient
	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name="location_name")
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Transient
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Transient
	public String getCityPm25() {
		return cityPm25;
	}

	public void setCityPm25(String cityPm25) {
		this.cityPm25 = cityPm25;
	}

	@Column(name="is_visible")
	public String getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}
	
	@Column(name="searchable",length=3)
	public String getSearchable() {
		return searchable;
	}

	public void setSearchable(String searchable) {
		this.searchable = searchable;
	}
	
	
	@Column(name="remindable",length=3)
	public String getRemindable() {
		return remindable;
	}

	public void setRemindable(String remindable) {
		this.remindable = remindable;
	}

	@Transient
	public int getDeviceState() {
		return deviceState;
	}


	public void setDeviceState(int deviceState) {
		this.deviceState = deviceState;
	}

	@Transient
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Transient
	public Integer getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(Integer dataUpload) {
		this.dataUpload = dataUpload;
	}
	@Transient
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	@Transient
	public int getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	@Transient
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	@Transient
	public int getShareCount() {
		return shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}

	@Transient
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Transient
	public int getUnlikeCount() {
		return unlikeCount;
	}

	public void setUnlikeCount(int unlikeCount) {
		this.unlikeCount = unlikeCount;
	}
	
	@Transient
	public Map<String, Object> getDataDetail() {
		return dataDetail;
	}

	public void setDataDetail(Map<String, Object> dataDetail) {
		this.dataDetail = dataDetail;
	}

	@Transient
	public Long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Transient
	public int getIsPraise() {
		return isPraise;
	}

	public void setIsPraise(int isPraise) {
		this.isPraise = isPraise;
	}


	@Transient
	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	@Transient
	public Map<String, String> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
}