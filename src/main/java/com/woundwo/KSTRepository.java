package com.woundwo;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class KSTRepository implements PanacheRepository<KST>{

	
	public KST findByPNumber(String PNumber){
	       return find("pnumber", PNumber).firstResult();
	   }
}
