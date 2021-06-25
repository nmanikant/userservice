package com.flightapp.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.userservice.entity.TicketBookingDetails;
import com.flightapp.userservice.service.BookingService;




@RestController
@RequestMapping("/api/v1.0/flight")
@CrossOrigin

public class Controller {
	
	@Autowired 
	BookingService bookingService;
	/*
	 * @Autowired RestTemplate restTemplate;
	 */
	


	 
	 /*booking service*/
	 
	 
	 @PostMapping("/book-flight")
	    public ResponseEntity<TicketBookingDetails> bookTicket(@RequestBody TicketBookingDetails ticketDetails)
	    {
		 TicketBookingDetails added =  bookingService.bookTicket(ticketDetails);
	        return new ResponseEntity<TicketBookingDetails>(added, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @GetMapping("/booking-history/{email}")
	    public ResponseEntity< List<TicketBookingDetails>> getDetailsByEmail(@PathVariable("email") String email) {
		 List<TicketBookingDetails> added =  bookingService.getDetailsByEmail(email);
	        return new ResponseEntity< List<TicketBookingDetails>>(added, new HttpHeaders(), HttpStatus.OK);
	    }
	 @GetMapping("/booking-history")
	    public ResponseEntity< List<TicketBookingDetails>> getDetails() {
		 List<TicketBookingDetails> added =  bookingService.getDetails();
	        return new ResponseEntity< List<TicketBookingDetails>>(added, new HttpHeaders(), HttpStatus.OK);
	    }
		
		  @DeleteMapping("/booking-history/{email}") public HttpStatus
		  deleteTicket(@PathVariable("email") String email) {
		  bookingService.deleteTicket(email); return HttpStatus.FORBIDDEN; }
		 
	 
		  @DeleteMapping("/booking-history/{id}") public HttpStatus
		  deleteTicketById(@PathVariable("id") int id) {
		  bookingService.deleteTicketById(id);; return HttpStatus.FORBIDDEN; }	  
	 
	 
	 /*spring security*/
	 
	 
	 
		/*
		 * @GetMapping("/user")
		 * 
		 * @ResponseBody public String greetUser() { return
		 * "Welcome User, I am greeting you...<p>Home <a href='/index.html'>Page</a></p>"
		 * ; }
		 * 
		 * @GetMapping("/admin")
		 * 
		 * @ResponseBody public String greetAdmin() { return
		 * "Welcome admin, I am greeting you...<p>Home <a href='/index.html'>Page</a></p>"
		 * ; }
		 */
	 
	 
	 
	 
}

