package com.cg.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*
 * The persistent class for the flight_details database table.
 * 
 */

@Entity
@Table(name="flight_details")
@DynamicInsert
@DynamicUpdate
public class Flight {

	@Id
	@Column(name="flight_code",length=10)
	private String flightCode;
	@Column(name="flight_name",length=25)
	private String flightName;
	@Column(name="seat_capacity",length=25)
	private int seatCapacity;

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	
}