/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.entity;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author anwarul
 */
@Entity
public class Recycling extends Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int company;

    public Recycling(int company, String name, Address address) {
        super(name, address);
        this.company = company;
    }

    public Recycling() {
       
    }

    public int getCapacity() {
        return company;
    }

    public void setCapacity(int capacity) {
        this.company = capacity;
    }


   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recycling)) {
            return false;
        }
        Recycling other = (Recycling) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cs.mum.entity.Recycling[ id=" + id + " ]";
    }
    
}
