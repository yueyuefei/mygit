package com.rockontrol.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WeatherAirDataHistoryGb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "weather_air_data_history_gb", catalog = "env")
public class WeatherAirDataHistoryGb implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String mn;
	private Date date;
	private String t00;
	private String t01;
	private String t02;
	private String t03;
	private String t04;
	private String t05;
	private String t06;
	private String t07;
	private String t08;
	private String t09;
	private String t10;
	private String t11;
	private String t12;
	private String t13;
	private String t14;
	private String t15;
	private String t16;
	private String t17;
	private String t18;
	private String t19;
	private String t20;
	private String t21;
	private String t22;
	private String t23;

	// Constructors

	/** default constructor */
	public WeatherAirDataHistoryGb() {
	}

	/** full constructor */
	public WeatherAirDataHistoryGb(String code, String mn, Date date,
			String t00, String t01, String t02, String t03, String t04,
			String t05, String t06, String t07, String t08, String t09,
			String t10, String t11, String t12, String t13, String t14,
			String t15, String t16, String t17, String t18, String t19,
			String t20, String t21, String t22, String t23) {
		this.code = code;
		this.mn = mn;
		this.date = date;
		this.t00 = t00;
		this.t01 = t01;
		this.t02 = t02;
		this.t03 = t03;
		this.t04 = t04;
		this.t05 = t05;
		this.t06 = t06;
		this.t07 = t07;
		this.t08 = t08;
		this.t09 = t09;
		this.t10 = t10;
		this.t11 = t11;
		this.t12 = t12;
		this.t13 = t13;
		this.t14 = t14;
		this.t15 = t15;
		this.t16 = t16;
		this.t17 = t17;
		this.t18 = t18;
		this.t19 = t19;
		this.t20 = t20;
		this.t21 = t21;
		this.t22 = t22;
		this.t23 = t23;
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

	@Column(name = "code", length = 20)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "mn", length = 20)
	public String getMn() {
		return this.mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	@Column(name = "date", length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "t00", length = 50)
	public String getT00() {
		return this.t00;
	}

	public void setT00(String t00) {
		this.t00 = t00;
	}

	@Column(name = "t01", length = 50)
	public String getT01() {
		return this.t01;
	}

	public void setT01(String t01) {
		this.t01 = t01;
	}

	@Column(name = "t02", length = 50)
	public String getT02() {
		return this.t02;
	}

	public void setT02(String t02) {
		this.t02 = t02;
	}

	@Column(name = "t03", length = 50)
	public String getT03() {
		return this.t03;
	}

	public void setT03(String t03) {
		this.t03 = t03;
	}

	@Column(name = "t04", length = 50)
	public String getT04() {
		return this.t04;
	}

	public void setT04(String t04) {
		this.t04 = t04;
	}

	@Column(name = "t05", length = 50)
	public String getT05() {
		return this.t05;
	}

	public void setT05(String t05) {
		this.t05 = t05;
	}

	@Column(name = "t06", length = 50)
	public String getT06() {
		return this.t06;
	}

	public void setT06(String t06) {
		this.t06 = t06;
	}

	@Column(name = "t07", length = 50)
	public String getT07() {
		return this.t07;
	}

	public void setT07(String t07) {
		this.t07 = t07;
	}

	@Column(name = "t08", length = 50)
	public String getT08() {
		return this.t08;
	}

	public void setT08(String t08) {
		this.t08 = t08;
	}

	@Column(name = "t09", length = 50)
	public String getT09() {
		return this.t09;
	}

	public void setT09(String t09) {
		this.t09 = t09;
	}

	@Column(name = "t10", length = 50)
	public String getT10() {
		return this.t10;
	}

	public void setT10(String t10) {
		this.t10 = t10;
	}

	@Column(name = "t11", length = 50)
	public String getT11() {
		return this.t11;
	}

	public void setT11(String t11) {
		this.t11 = t11;
	}

	@Column(name = "t12", length = 50)
	public String getT12() {
		return this.t12;
	}

	public void setT12(String t12) {
		this.t12 = t12;
	}

	@Column(name = "t13", length = 50)
	public String getT13() {
		return this.t13;
	}

	public void setT13(String t13) {
		this.t13 = t13;
	}

	@Column(name = "t14", length = 50)
	public String getT14() {
		return this.t14;
	}

	public void setT14(String t14) {
		this.t14 = t14;
	}

	@Column(name = "t15", length = 50)
	public String getT15() {
		return this.t15;
	}

	public void setT15(String t15) {
		this.t15 = t15;
	}

	@Column(name = "t16", length = 50)
	public String getT16() {
		return this.t16;
	}

	public void setT16(String t16) {
		this.t16 = t16;
	}

	@Column(name = "t17", length = 50)
	public String getT17() {
		return this.t17;
	}

	public void setT17(String t17) {
		this.t17 = t17;
	}

	@Column(name = "t18", length = 50)
	public String getT18() {
		return this.t18;
	}

	public void setT18(String t18) {
		this.t18 = t18;
	}

	@Column(name = "t19", length = 50)
	public String getT19() {
		return this.t19;
	}

	public void setT19(String t19) {
		this.t19 = t19;
	}

	@Column(name = "t20", length = 50)
	public String getT20() {
		return this.t20;
	}

	public void setT20(String t20) {
		this.t20 = t20;
	}

	@Column(name = "t21", length = 50)
	public String getT21() {
		return this.t21;
	}

	public void setT21(String t21) {
		this.t21 = t21;
	}

	@Column(name = "t22", length = 50)
	public String getT22() {
		return this.t22;
	}

	public void setT22(String t22) {
		this.t22 = t22;
	}

	@Column(name = "t23", length = 50)
	public String getT23() {
		return this.t23;
	}

	public void setT23(String t23) {
		this.t23 = t23;
	}

}