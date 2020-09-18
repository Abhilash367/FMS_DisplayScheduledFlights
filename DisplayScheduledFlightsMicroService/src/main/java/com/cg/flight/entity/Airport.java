package com.cg.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*
 * The persistent class for the Airports database table.
 * 
 */

@Entity
@Table(name="Airports")
@DynamicInsert
@DynamicUpdate
public class Airport {
	
	@Id
	@Column(name="airport_code", length=10)
	private String airportCode;
	
	@Column(name="airport_name",length=50)
	private String airportName;
	

	@Column(name="airport_location",length=50)
	private String airportLocation;

	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return airportCode + " " + airportName + " " + airportLocation;
	}
	 
	
	

}
