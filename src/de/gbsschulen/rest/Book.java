package de.gbsschulen.rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@Entity
public class Book {

    @Id
    private int id;
    private String autor;
    private String isbn;
    private String titel;

    public Book() {
    }

    public Book(int id, String autor, String isbn, String titel) {
        this.id = id;
        this.autor = autor;
        this.isbn = isbn;
        this.titel = titel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(autor, book.autor) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(titel, book.titel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, autor, isbn, titel);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titel='" + titel + '\'' +
                '}';
    }
}
