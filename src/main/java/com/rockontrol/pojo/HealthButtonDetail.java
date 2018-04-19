package com.rockontrol.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HealthControlButton entity. @author MyEclipse Persistence Tools
 * 遥控面板按钮明细
 */
@Entity
@Table(name = "health_button_detail")
public class HealthButtonDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Long buttonId;
	private String name;
	private String code;
	private String des;

	// Constructors

	/** default constructor */

	public HealthButtonDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HealthButtonDetail(Long id, String name, 
			Long buttonId, String code, String des) {
		super();
		this.id = id;
		this.name = name;
		this.buttonId = buttonId;
		this.code = code;
		this.des = des;
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

	@Column(length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="panel_id")
	public Long getButtonId() {
		return buttonId;
	}

	public void setButtonId(Long buttonId) {
		this.buttonId = buttonId;
	}

	@Column(length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(length = 50)
	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}