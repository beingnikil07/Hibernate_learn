package com.nikhil.DemoHibernate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="students")  //creates a new table 
public class Alien  
{	@Id
	@Column(name="sid")
    private int id;
	@Column(name="sname")
    private String name;
    private String color;
    public int getAid() {
        return id;
    }

    public void setAid(int id) {
        this.id = id;
    }

    public String getAname() {
        return name;
    }

    public void setAname(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
    
    


}
