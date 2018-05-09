package de.gbsschulen.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookstore")
public class BookResource {

    private BookService bookService = new BookService();

    // http://localhost:9090/rest/bookstore/1

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("id") int id) {
        Book book = bookService.getBook(id);
        return book;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String deleteBook(@PathParam("id") int id) {
        Book book = bookService.deleteBook(id);
        if (book != null) {
            return book.getTitel() + " wurde aus DB gelöscht!";
        }
        return "nichts gelöscht!";
    }

    // http://localhost:9090/rest/bookstore/book?id=2
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/book/")
    public Book gibBuch(@QueryParam("id") int id) {
        Book book = bookService.getBook(id);
        return book;
    }
}
