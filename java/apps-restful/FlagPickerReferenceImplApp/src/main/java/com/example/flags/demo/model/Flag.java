package com.example.flags.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name="flag")
public class Flag {

	@Id
	@GeneratedValue
	private Long id;
	@Column (name="continent")
	private String continent;
	@Column (name="nation")
	private String nation;
	@Column (name="flag")
	private String flag;
	
	public Flag() {
	}
	
	public Flag(String continent, String nation, String flag) {
		this.continent = continent;
		this.nation = nation;
		this.flag = flag;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
