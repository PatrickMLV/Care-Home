package fr.umlv.m2.jee.j2e.persistance.book;

import java.util.List;

import fr.umlv.m2.jee.dao.IDAO;
import org.joda.time.DateTime;

public interface BookDAO extends IDAO<Long, Book> {
    public Book findBookWithISBN(String isbn);

    public List<Book> findBookByPublicationDate(DateTime date);
}
