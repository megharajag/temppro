package com.spring.basic.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Ticket")
/*
 * @Getter
 * 
 * @Setter
 */
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double amount;
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", amount=" + amount + ", catagory=" + catagory + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	private String catagory;
	
	
}
