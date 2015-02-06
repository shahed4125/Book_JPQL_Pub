/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.edu.EJB;

import cs.mum.entity.Address;
import cs.mum.entity.Author;
import cs.mum.entity.Book;
import cs.mum.entity.Company;
import cs.mum.entity.Publisher;
import cs.mum.entity.States;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author anwarul
 */
@Stateless
@LocalBean
public class AuthorEJB {

    @PersistenceContext
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

public void save(Author author){

em.persist(author);
}

public void savepub(Publisher pub){

em.persist(pub);

}

public void saveaddress(Address adrs){

em.persist(adrs);
}

public void savestate(States state){

em.persist(state);

}

public List<Book> bookBypopulation(int pop){

TypedQuery<Book> query = em.createQuery("Select b from Book b where b.author.address.state.population > :population",Book.class);
 query.setParameter("population", pop);
 return query.getResultList();
} 


public List<Publisher> publisherByrank(int rating){

TypedQuery<Publisher> query = em.createQuery("Select p from Publisher p JOIN p.booklist b where b.author.rating >= :rank", Publisher.class);
query.setParameter("rank", rating);
return query.getResultList();

}

public List<Book> bookbyrankpop(int rating, int pop){

TypedQuery<Book> query = em.createQuery("select b from Book b WHERE b.author.address.state.population = :population AND b.author.rating = :rank", Book.class);
query.setParameter("rank", rating);
query.setParameter("population", pop);
return query.getResultList();

}

 public void deleteData()
    {

        TypedQuery<Book> query1= em.createQuery("Select b from Book b",Book.class);
        List<Book> books=query1.getResultList();
        for(Book b: books)
        {
            em.remove(b);
        }
        
        TypedQuery<Author> query2= em.createQuery("Select a from Author a",Author.class);
        List<Author> authors=query2.getResultList();
        for(Author a: authors)
        {
            em.remove(a);
        }
        TypedQuery<Company> query4= em.createQuery("Select a from Company a",Company.class);
        List<Company> companies=query4.getResultList();
        for(Company c: companies)
        {
            em.remove(c);
        }
        
        TypedQuery<Address> query3= em.createQuery("Select a from Address a",Address.class);
        List<Address> addresses=query3.getResultList();
        for(Address a: addresses)
        {
            em.remove(a);
        }
        
        TypedQuery<States> query5= em.createQuery("Select a from States a",States.class);
        List<States> states=query5.getResultList();
        for(States s: states)
        {
            em.remove(s);
        }
       
    }

}
