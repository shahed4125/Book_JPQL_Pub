/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.edu.MB;

import cs.mum.edu.EJB.AuthorEJB;
import cs.mum.entity.Address;
import cs.mum.entity.Author;
import cs.mum.entity.Book;
import cs.mum.entity.Publisher;
import cs.mum.entity.States;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author anwarul
 */
@ManagedBean(name="datamb")
@RequestScoped
public class DataMB {


    @EJB
    AuthorEJB authejb;
    
   
       public   Address address = new Address();
       public  States state = new States();
       
       private List<Book> Books = new ArrayList<Book>();
       public List<Publisher> pubs = new ArrayList<Publisher>();
       private List<Book> Booklist = new ArrayList<Book>();
        
       private int pop;
       private int rank;

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getRank() {
        return rank;
    }

    public List<Publisher> getPubs() {
        return pubs;
    }

    public void setPubs(List<Publisher> pubs) {
        this.pubs = pubs;
    }

    public List<Book> getBooklist() {
        return Booklist;
    }

    public void setBooklist(List<Book> Booklist) {
        this.Booklist = Booklist;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> Books) {
        this.Books = Books;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }
    
    
    public String findbookbypop(){
    
    Books=authejb.bookBypopulation(pop);
    return "QueryPage";
    
    }
    
    public String findpubbyrank(){
    
       pubs = authejb.publisherByrank(rank);
        return "QueryPage";
        
    }
    
    public String findbookbyrankpop(){
    
    Booklist =authejb.bookbyrankpop(rank, pop);
    
    return "QueryPage";
    }
    
    
    public String addaddress(){
    
        authejb.saveaddress(address);
        return "show";
    }
  
    
      public String AddState(){
    
        authejb.savestate(state);
        return "show";
    }
      
    /**
     * Creates a new instance of DataMB
     */
    public DataMB() {
        
       

    }
     public String addall(){
     
     States state1 = new States("IOWA", 1200);
     States state2 = new States("New York", 1500);
     States state3 = new States("Florida", 1300);

    Address ad1=new Address("Fairfield",12,state1);
    Address ad2=new Address("Jackson Height",23,state2);
    Address ad3=new Address("Miami",15,state3);
    
    Author auth1 = new Author("Anwar",2,ad1);
    Author auth2 = new Author("Jamal",3,ad2);
    Author auth3 = new Author("Ismail",3,ad3);
    
    Publisher pub1 = new Publisher(2,"Samakal",ad1);
    Publisher pub2 = new Publisher(4,"Quiest",ad2);
    Publisher pub3 = new Publisher(4,"koko",ad3);
    
    Book b1 = new Book("java1", 12,"jjjj", auth1);
    Book b2 = new Book("C++", 14,"kkkk", auth2);   
    Book b3 = new Book("Networking", 14,"kkkk", auth3);
    //auth1.addbook(b1);
    
    b1.addpublisher(pub1);
    b2.addpublisher(pub2);
    b3.addpublisher(pub3);
  
   
   //pub1.addbook(b2);
//   pub1.addbook(b1);
  // auth1.addbook(b2);
    
    authejb.save(auth1);
    authejb.save(auth2);
    authejb.save(auth3);
   // authejb.savepub(pub1);
  //  authejb.savepub(pub2);
     return "show";
     }
     
     public String deleteall(){
     
     authejb.deleteData();
     return "DeletePage";
     
     
     }
}

