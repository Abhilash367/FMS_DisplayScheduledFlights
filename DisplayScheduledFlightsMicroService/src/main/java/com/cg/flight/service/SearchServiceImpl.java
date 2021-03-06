package com.cg.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.flight.dao.ScheduledFlightDao;
import com.cg.flight.entity.ScheduledFlight;
import com.cg.flight.exceptions.LoginException;
import com.cg.flight.exceptions.SearchException;
import com.cg.flight.util.FlightConstants;


@Service
public class SearchServiceImpl implements SearchService {

	private Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	@Autowired
	private ScheduledFlightDao searchDao;
	
	@Autowired
	private RestTemplate rt;
	
	

	@Override
	public List<ScheduledFlight> searchFlights(String src, String dest, LocalDate doj) throws SearchException {
        List<ScheduledFlight> flist= searchDao.searchflight(src, dest);
        if(flist.isEmpty())
        	throw new SearchException(FlightConstants.FLIGHT_NOT_AVAILABLE);
        
		flist = flist.stream().filter(schflight->schflight.getArrivalTime().toLocalDate().equals(doj)).collect(Collectors.toList());
		 if(flist.isEmpty())
	        	throw new SearchException(FlightConstants.FLIGHT_NOT_AVAILABLE);
		flist.sort((sf1, sf2)->Double.valueOf(sf1.getFare()).compareTo(sf2.getFare()) );
        return flist;
	}



	@Override
	public String validateTokenInLoginRestController(String tokenId) throws LoginException {
		if(tokenId==null || tokenId.length()==0) throw new LoginException(FlightConstants.USER_NOT_AUTHORIZED);
		String url="http:localhost:8087/flight/verifylogin";
		String role= rt.postForObject(url, tokenId, String.class);
		logger.info(FlightConstants.USER_NOT_AUTHENTICATED);
		return role;
	}

	

}
