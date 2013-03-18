package fr.umlv.m2.jee.j2e.persistance.book;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.umlv.m2.jee.j2e.persistance.author.Author;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private long id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRINTED_DATE")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime printedDate;

    @Column(name = "PUBLICATION_DATE")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime publicationDate;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    //@Column(name="AUTHORS")
    //private final List<Author> authors;

    public Book() {
        ;
    }

    public Book(long id, String isbn, String title, DateTime printedDate, DateTime publicationDate, Author author) {
        Objects.requireNonNull(isbn);
        Objects.requireNonNull(title);
        Objects.requireNonNull(printedDate);
        Objects.requireNonNull(publicationDate);
        Objects.requireNonNull(author);

        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.printedDate = printedDate;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        Objects.requireNonNull(isbn);
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Objects.requireNonNull(title);
        this.title = title;
    }

    public DateTime getPrintedDate() {
        return printedDate;
    }

    public void setPrintedDate(DateTime printedDate) {
        Objects.requireNonNull(printedDate);
        this.printedDate = printedDate;
    }

    public DateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(DateTime publicationDate) {
        Objects.requireNonNull(publicationDate);
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        Objects.requireNonNull(author);
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (printedDate != null ? !printedDate.equals(book.printedDate) : book.printedDate != null) return false;
        if (publicationDate != null ? !publicationDate.equals(book.publicationDate) : book.publicationDate != null)
            return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (printedDate != null ? printedDate.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        return result;
    }
}
