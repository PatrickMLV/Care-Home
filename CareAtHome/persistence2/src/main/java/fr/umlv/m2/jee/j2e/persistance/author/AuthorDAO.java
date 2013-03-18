package fr.umlv.m2.jee.j2e.persistance.author;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.j2e.persistance.book.Book;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;

public interface AuthorDAO extends IDAO<Long, Author> {
    public Author findAuthorWithSSID(String ssid);

    public Set<Book> getBookFromAuthor(long id);

    public List<Author> findAuthorByBirthDate(DateTime date);

    public List<Author> findAuthorByDeathDate(DateTime date);
}