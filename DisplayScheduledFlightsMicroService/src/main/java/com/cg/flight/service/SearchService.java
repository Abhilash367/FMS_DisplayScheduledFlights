package com.cg.flight.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.SearchException;

public interface SearchService {
  public List<ScheduledFlight> searchFlights(String src, String dest, LocalDate dt)throws SearchException;
  
  public String validateTokenInLoginRestController(String tokenId) throws LoginException;
}
