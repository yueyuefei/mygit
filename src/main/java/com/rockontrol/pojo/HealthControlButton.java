package com.rockontrol.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * HealthControlButton entity. @author MyEclipse Persistence Tools
 * 遥控面板按钮
 */
@Entity
@Table(name = "health_control_button")
public class HealthControlButton implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String icon;
	private Long panelId;
	private String code;
	private Integer state;
	private String des;
	private List<HealthButtonDetail> list;
	private Integer groupSize;
	private String groupState;

	// Constructors

	/** default constructor */

	public HealthControlButton() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HealthControlButton(Long id, String name, String icon,
			Long panelId, String code, String des) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.panelId = panelId;
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

	@Column(length = 50)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name="panel_id")
	public Long getPanelId() {
		return panelId;
	}

	public void setPanelId(Long panelId) {
		this.panelId = panelId;
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

	@Column
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Transient
	public List<HealthButtonDetail> getList() {
		return list;
	}

	public void setList(List<HealthButtonDetail> list) {
		this.list = list;
	}

	@Transient
	public Integer getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}

	@Transient
	public String getGroupState() {
		return groupState;
	}

	public void setGroupState(String groupState) {
		this.groupState = groupState;
	}

}