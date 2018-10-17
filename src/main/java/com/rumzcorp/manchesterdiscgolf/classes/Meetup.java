package com.rumzcorp.manchesterdiscgolf.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meetup_tbl")
public class Meetup {
	
	@Id
	@GeneratedValue
	private int id;
		
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private String time;
	
	@Column(nullable = false)
	private String roundType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoundType() {
		return roundType;
	}

	public void setRoundType(String roundType) {
		this.roundType = roundType;
	}
	
}
