package fr.umlv.m2.jee.j2e.persistance.author.impl;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;
import fr.umlv.m2.jee.j2e.persistance.author.Author;
import fr.umlv.m2.jee.j2e.persistance.author.AuthorDAO;
import fr.umlv.m2.jee.j2e.persistance.book.Book;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static java.util.Collections.EMPTY_SET;

@Repository
public class CriteriaAuthorDAO extends AbstractHibernateDAO<Long, Author> implements AuthorDAO {
    //findByCriteria

    @Override
    public Author findAuthorWithSSID(String ssid) {
        Criterion criterion = Restrictions.like("ssid", ssid);
        List<Author> authors = findByCriteria(criterion);

        if (authors.isEmpty()) {
            return null;
        }

        return authors.get(0);
    }

    @Override
    public Set<Book> getBookFromAuthor(long id) {
        Criterion criterion = Restrictions.like("id", id);
        List<Author> authors = findByCriteria(criterion);

        if (authors.isEmpty()) {
            return EMPTY_SET;
        }

        return authors.get(0).getBooks();
    }

    @Override
    public List<Author> findAuthorByBirthDate(DateTime date) {
        Criterion criterion = Restrictions.like("birthDate", date);
        return findByCriteria(criterion);
        }

    @Override
    public List<Author> findAuthorByDeathDate(DateTime date) {
        Criterion criterion = Restrictions.like("deathDate", date);
        return findByCriteria(criterion);
    }
}
