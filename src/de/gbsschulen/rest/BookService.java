package de.gbsschulen.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class BookService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BookService() {
        emf = Persistence.createEntityManagerFactory("books");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }


    public Book getBook(int id) {
        return em.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> typedQuery = em.createQuery("SELECT b from Book b", Book.class);
        return typedQuery.getResultList();
    }

    public Book deleteBook(int id) {
        Book book = getBook(id);
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        return book;
    }

    public void add(Book book) {
        if (book != null) {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        }
    }

    public void change(Book book) {
        if (book != null) {
            em.getTransaction().begin();
            em.merge(book);
            em.flush();
            em.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        Book book = bookService.getBook(1);
        System.out.println(book);
        List<Book> allBooks = bookService.getAllBooks();
        for (Book b : allBooks) {
            System.out.println(b);
        }
        bookService.close();
    }

}
