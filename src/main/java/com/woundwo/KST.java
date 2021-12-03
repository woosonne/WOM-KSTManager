package com.woundwo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class KST extends PanacheEntity {
	
	//@Id @GeneratedValue private Long id;
	public String pnumber;
	public String newkst;
	public LocalDateTime tstamp;
	
	
	public KST() {
		super();
	
	}
	
	public KST(String pnumber, String newkst, LocalDateTime tstamp) {
		super();
		this.pnumber = pnumber;
		this.newkst = newkst;
		this.tstamp = tstamp;
	}



	/*
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}
	public String getNewkst() {
		return newkst;
	}
	public void setNewkst(String newkst) {
		this.newkst = newkst;
	}
	public LocalDateTime getTstamp() {
		return tstamp;
	}
	public void setTstamp(LocalDateTime tstamp) {
		this.tstamp = tstamp;
	}
	
*/
	public static KST findByPNumber(String PNumber){
	       return find("pnumber", PNumber).firstResult();
	   }

}
