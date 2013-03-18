package fr.umlv.m2.jee.j2e.persistance.author;

import fr.umlv.m2.jee.j2e.persistance.book.Book;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/persistance-test-context.xml"})
public class TestAuthorDAO extends TestAbstractDAO<Long, Author> {

    @Qualifier("criteriaAuthorDAO")
    @Autowired
    private AuthorDAO authorDAO;

	@Override
	protected long countAll() {
		return 1;
	}

	@Override
	protected IDAO<Long, Author> getIDAO() {
        return authorDAO;
	}

    @Test
    public void testFindBySSID() {
        Author author = authorDAO.findAuthorWithSSID("19201AS");

        assertEquals(42, author.getId());
        assertEquals("Tolkien", author.getLastName());
    }

    @Test
    public void testBookFromAuthor() {
        Author author = authorDAO.findAuthorWithSSID("19201AS");
        Set<Book> books = authorDAO.getBookFromAuthor(author.getId());

        Set<Book> expected = new HashSet<Book>();

        expected.add(new Book(1, "ISBN-0-618-57494-8", "The Fellowship of the Ring", DateTime.parse("2005-01-01"), DateTime.parse("1954-07-24"), author));
        expected.add(new Book(2, "ISBN-0-618-57495-8", "The Two Towers", DateTime.parse("2005-01-01"), DateTime.parse("1954-11-11"), author));
        expected.add(new Book(3, "ISBN-0-618-57496-8", "The Return of the King", DateTime.parse("2005-01-01"), DateTime.parse("1955-10-20"), author));

        assertEquals(expected, books);
    }

    @Test
    public void testFindByBirthDate() {
        List<Author> authors = authorDAO.findAuthorByBirthDate(DateTime.parse("1982-01-03"));
        Author author = authorDAO.findAuthorWithSSID("19201AS");

        assertEquals(author, authors.get(0));
    }

    @Test
    public void testFindByDeathDate() {
        List<Author> authors = authorDAO.findAuthorByDeathDate(DateTime.parse("1973-09-02"));
        Author author = authorDAO.findAuthorWithSSID("19201AS");

        assertEquals(author, authors.get(0));
    }
}
