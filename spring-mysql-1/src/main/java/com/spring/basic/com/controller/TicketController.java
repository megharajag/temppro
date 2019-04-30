package com.spring.basic.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.basic.com.model.Ticket;
import java.util.List;


import com.spring.basic.com.dao.TicketDao;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody Ticket tickets)
	{
		dao.save(tickets);
		System.out.println(tickets.getAmount());
		return "Success";
	}
	@GetMapping("/getTickets")
	public List<Ticket> getTickets(){
		return (List<Ticket>) dao.findAll();
	}
	
	@RequestMapping(value = "/updateTickets/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTicket(@PathVariable("id") int id, @RequestBody Ticket tickets) {
   //     logger.info("Updating User with id {}", id);
 
        Ticket currentTicket = dao.findById(id);
 
        if (currentTicket == null) {
           //System.out.println("Unable to update. User with id {} not found.", id);
        	return new ResponseEntity<Ticket>(currentTicket, HttpStatus.BAD_REQUEST);
        	
        }
 
        currentTicket.setAmount(tickets.getAmount());
        currentTicket.setCatagory(tickets.getCatagory());
 
        dao.saveAndFlush(currentTicket);
        return new ResponseEntity<Ticket>(currentTicket, HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
	       // logger.info("Fetching & Deleting User with id {}", id);
	 
	        Ticket deleteTicket = dao.findById(id);
	        if (deleteTicket == null) {
	          //  logger.error("Unable to delete. User with id {} not found.", id);
	        	return new ResponseEntity<Ticket>(deleteTicket, HttpStatus.BAD_REQUEST);
	        }
	        dao.deleteById(id);
	        return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
	    }
}
