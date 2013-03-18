package fr.umlv.m2.jee.j2e.persistance.book.impl;

import java.util.List;

import javax.persistence.Query;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;
import fr.umlv.m2.jee.j2e.persistance.book.Book;
import fr.umlv.m2.jee.j2e.persistance.book.BookDAO;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultBookDAO extends AbstractHibernateDAO<Long, Book> implements BookDAO {

    @Override
    public Book findBookWithISBN(String isbn) {
        Query query = createQuery("SELECT b FROM Book b WHERE b.isbn=:isbn");
        query.setParameter("isbn", isbn);

        List<Book> result = query.getResultList();

        if (result.size() == 0) {
            return null;
        }
        if (result.size() != 1) {
            throw new IllegalStateException("There is " + result.size() + " books with the same ISBN.");
        }

        return result.get(0);
    }

    @Override
    public List<Book> findBookByPublicationDate(DateTime date) {
        Query query = createQuery("SELECT b FROM Book b WHERE b.publicationDate=:date");
        query.setParameter("date", date);

        return query.getResultList();
    }
}
