package com.spring.basic.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.basic.com.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
    Ticket findById(int id);

}
