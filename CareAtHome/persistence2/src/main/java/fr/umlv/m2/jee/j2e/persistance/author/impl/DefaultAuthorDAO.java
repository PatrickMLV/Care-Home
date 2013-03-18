package fr.umlv.m2.jee.j2e.persistance.author.impl;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;
import fr.umlv.m2.jee.j2e.persistance.author.Author;
import fr.umlv.m2.jee.j2e.persistance.author.AuthorDAO;

import fr.umlv.m2.jee.j2e.persistance.book.Book;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class DefaultAuthorDAO extends AbstractHibernateDAO<Long, Author> implements AuthorDAO {

    @Override
    public Author findAuthorWithSSID(String ssid) {
        Query query = createQuery("SELECT a FROM Author a WHERE a.ssid=:ssid");
        query.setParameter("ssid", ssid);

        return (Author) query.getSingleResult();
    }

    @Override
    public Set<Book> getBookFromAuthor(long id) {
        Query query = createQuery("SELECT a FROM Author a WHERE a.id=:id");
        query.setParameter("id", id);

        return ((Author) query.getSingleResult()).getBooks();
    }

    @Override
    public List<Author> findAuthorByBirthDate(DateTime date) {
        Query query = createQuery("SELECT a FROM Author a WHERE a.birthDate=:date");
        query.setParameter("date", date);

        return query.getResultList();
    }

    @Override
    public List<Author> findAuthorByDeathDate(DateTime date) {
        Query query = createQuery("SELECT a FROM Author a WHERE a.deathDate=:date");
        query.setParameter("date", date);

        return query.getResultList();
    }
}
