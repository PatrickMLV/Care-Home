package fr.umlv.m2.jee.j2e.persistance.book.impl;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;
import fr.umlv.m2.jee.j2e.persistance.author.Author;
import fr.umlv.m2.jee.j2e.persistance.book.Book;
import fr.umlv.m2.jee.j2e.persistance.book.BookDAO;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CriteriaBookDAO extends AbstractHibernateDAO<Long, Book> implements BookDAO {

    @Override
    public Book findBookWithISBN(String isbn) {
        Criterion criterion = Restrictions.like("isbn", isbn);
        List<Book> books = findByCriteria(criterion);

        if (books.isEmpty()) {
            return null;
        }

        return books.get(0);
    }

    @Override
    public List<Book> findBookByPublicationDate(DateTime date) {
        Criterion criterion = Restrictions.like("publicationDate", date);
        return findByCriteria(criterion);
    }
}
