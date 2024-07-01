package com.nikhil.DemoHibernate;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)

public class Alien  
{	@Id
    private int Aid;
    private AlienName name;
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public AlienName getName() {
		return name;
	}
	public void setName(AlienName name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Alien [Aid=" + Aid + ", name=" + name + "]";
	}
   
}
