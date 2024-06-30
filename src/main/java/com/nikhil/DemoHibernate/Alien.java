package com.nikhil.DemoHibernate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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
