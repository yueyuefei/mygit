package com.rockontrol.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WeatherStationDataHourtimeMap entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "weather_station_data_hourtime_map", catalog = "env")
public class WeatherStationDataHourtimeMap implements java.io.Serializable {

	// Fields

	private Long id;
	private String mn;
	private String phone;
	private String code;
	private String value;
	private String gatherTime;

	// Constructors

	/** default constructor */
	public WeatherStationDataHourtimeMap() {
	}

	/** full constructor */
	public WeatherStationDataHourtimeMap(String mn, String phone, String code,
			String value, String gatherTime) {
		this.mn = mn;
		this.phone = phone;
		this.code = code;
		this.value = value;
		this.gatherTime = gatherTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "mn", length = 32)
	public String getMn() {
		return this.mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	@Column(name = "phone", length = 16)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "code", length = 8)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "value", length = 30)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "gather_time", length = 30)
	public String getGatherTime() {
		return this.gatherTime;
	}

	public void setGatherTime(String gatherTime) {
		this.gatherTime = gatherTime;
	}

}