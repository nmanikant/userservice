package com.flightapp.userservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.userservice.entity.TicketBookingDetails;



@Repository
public interface TicketBookingDetailsRepo extends JpaRepository<TicketBookingDetails, Integer> {
	
	@Query("SELECT f FROM TicketBookingDetails f  WHERE f.email=?1 ")
	List<TicketBookingDetails> getByEmail(String email);
	

	
	  @Query("DELETE FROM TicketBookingDetails f  WHERE f.email=?1 ") 
	  void  deleteByEmail(String email);
	 
	
	
	

}
