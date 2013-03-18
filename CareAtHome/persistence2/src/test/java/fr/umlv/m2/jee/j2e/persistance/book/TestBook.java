package fr.umlv.m2.jee.j2e.persistance.book;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import fr.umlv.m2.jee.j2e.persistance.author.Author;

public class TestBook {
	@Test(expected=NullPointerException.class)
	public void testConstructTitle() {
		new Book(0, "123", null, new DateTime(), new DateTime(), new Author());
	}

    //TODO REFAIRE LES TESTS !

    @Test(expected=NullPointerException.class)
    public void testConstructNullDate() {
        new Book(0, "123", "Toto", null, new DateTime(), new Author());
    }

    @Test(expected=NullPointerException.class)
    public void testConstructNullDate2() {
        new Book(0, "123", "Toto", new DateTime(), null, new Author());
    }
	
	@Test(expected=NullPointerException.class)
	public void testConstructNullAuthor() {
		new Book(0, "123", "Toto", new DateTime(), new DateTime(), null);
	}

	@Test
	public void testGetters() {
        Author author = new Author(42, "123", "Toto", "Tata", new DateTime(), new DateTime().plusYears(60));
		long id = 0;
        String isbn = "12.5";
		String title = "Tutu";
		DateTime printedDate = new DateTime();
		Book book = new Book(id, isbn, title, printedDate, printedDate, author);
		
		assertEquals(id, book.getId());
        assertEquals(isbn, book.getIsbn());
		assertEquals(title, book.getTitle());
        assertEquals(printedDate, book.getPrintedDate());
        assertEquals(printedDate, book.getPublicationDate());
		assertEquals(author, book.getAuthor());
	}
}