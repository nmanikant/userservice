package com.flightapp.userservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.userservice.entity.TicketBookingDetails;
import com.flightapp.userservice.repo.TicketBookingDetailsRepo;



@Service
@Transactional
public class BookingService {
	@Autowired
    private TicketBookingDetailsRepo repo;
	
	
	 public TicketBookingDetails bookTicket(TicketBookingDetails ticketDetails) {
	       return repo.save(ticketDetails);
	    }
	 
	 public List<TicketBookingDetails> getDetailsByEmail(String email) {
		 
	       return repo.getByEmail(email);
	    }
	 public List<TicketBookingDetails> getDetails() {
		 
	       return repo.findAll();
	    }
	 public void deleteTicketById(int id) {
		  repo.deleteById(id);
	 }
		
		  public void deleteTicket(String email) {
		  
		  repo.deleteByEmail(email);; }
		 

}
