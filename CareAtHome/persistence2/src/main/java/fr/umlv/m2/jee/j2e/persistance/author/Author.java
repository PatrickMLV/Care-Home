package fr.umlv.m2.jee.j2e.persistance.author;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import fr.umlv.m2.jee.j2e.persistance.book.Book;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;


@Entity
@Table(name = "AUTHOR")
public class Author {
	@Id
	@GeneratedValue
	@Column(name = "AUTHOR_ID")
	private long id;

    @Column(name = "SSID")
    private String ssid;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "FIRSTNAME")
	private String firstName;

    @Column(name = "BIRTHDATE")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime birthDate;

    @Column(name = "DEATHDATE", nullable = true)
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime deathDate;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    private Set<Book> books;

    public Author() {
        ;
    }

	public Author(long id, String ssid, String lastName, String firstName,
                  DateTime birthDate, DateTime deathDate) {
        Objects.requireNonNull(ssid);
		Objects.requireNonNull(lastName);
		Objects.requireNonNull(firstName);
		Objects.requireNonNull(birthDate);
		
		this.id = id;
        this.ssid = ssid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
        this.deathDate = deathDate;
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        Objects.requireNonNull(ssid);
        this.ssid = ssid;
    }

    public String getLastName() {
        Objects.requireNonNull(lastName);
        return lastName;
    }

    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName);
        this.firstName = firstName;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        Objects.requireNonNull(birthDate);
        this.birthDate = birthDate;
    }

    public DateTime getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(DateTime deathDate) {
        this.deathDate = deathDate;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        Objects.requireNonNull(books);
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (birthDate != null ? !birthDate.equals(author.birthDate) : author.birthDate != null) return false;
        if (deathDate != null ? !deathDate.equals(author.deathDate) : author.deathDate != null) return false;
        if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) return false;
        if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;
        if (ssid != null ? !ssid.equals(author.ssid) : author.ssid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ssid != null ? ssid.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        return result;
    }
}