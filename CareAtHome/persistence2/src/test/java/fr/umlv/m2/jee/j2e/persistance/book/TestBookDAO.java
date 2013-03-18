package fr.umlv.m2.jee.j2e.persistance.book;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/persistance-test-context.xml"})
public class TestBookDAO extends TestAbstractDAO<Long, Book> {
    @Qualifier("criteriaBookDAO")
    @Autowired
    private BookDAO bookDAO;

    @Override
    protected long countAll() {
        return 3;
    }

    @Override
    protected IDAO<Long, Book> getIDAO() {
        return bookDAO;
    }

    @Test
    public void testFindISBN() {
        Book book = bookDAO.findBookWithISBN("ISBN-0-618-57494-8");

        assertEquals("The Fellowship of the Ring", book.getTitle());
    }

    @Test
    public void testFindPublicationDate() {
        List<Book> books = bookDAO.findBookByPublicationDate(DateTime.parse("1954-11-11"));

        assertEquals("The Two Towers", books.get(0).getTitle());
    }
}