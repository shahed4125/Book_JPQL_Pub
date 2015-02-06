/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author anwarul
 */
@Entity
public class Publisher extends Company  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int rating;
    
    
    
    //@OneToMany(mappedBy="publisher", cascade= CascadeType.ALL)
    @OneToMany(mappedBy="publisher",cascade= CascadeType.ALL)
    public List<Book> booklist= new ArrayList<Book>();

    public Publisher(int rating, String name, Address address) {
        super(name, address);
        this.rating = rating;
    }

    public Publisher(int rating) {
        this.rating = rating;
    }

      public Publisher(){
      
      }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
 
    
   public void addbook(Book book){
   
   booklist.add(book);
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
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cs.mum.entity.Publisher[ id=" + id + " ]";
    }
    
}
