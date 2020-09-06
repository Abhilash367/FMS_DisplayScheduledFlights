package com.cg.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flight.entity.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport, String>{


}
