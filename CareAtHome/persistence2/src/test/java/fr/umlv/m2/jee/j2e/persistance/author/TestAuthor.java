package fr.umlv.m2.jee.j2e.persistance.author;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAuthor {
    @Test(expected=NullPointerException.class)
    public void testConstructNullSSID() {
        new Author(0, null, "tata", "toto", new DateTime(), null);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructNullLastName() {
        new Author(0, "123", null, "toto", new DateTime(), null);
    }
	
	@Test(expected=NullPointerException.class)
	public void testConstructNullFirstName() {
		new Author(0, "123", "toto", null, new DateTime(), null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testConstructNullDate() {
		new Author(0, "123", "toto", "tata", null, null);
	}

	@Test
	public void testGetters() {
		String lastName = "Titi";
		String firstName = "Tata";
		DateTime birthDate = new DateTime();
        DateTime deathDate = birthDate.plusYears(60);
		int id = 0;
        String ssid = "123";
		Author author = new Author(id, ssid, lastName, firstName, birthDate, deathDate);
		
		assertEquals(id, author.getId());
        assertEquals(ssid, author.getSsid());
		assertEquals(lastName, author.getLastName());
		assertEquals(firstName, author.getFirstName());
		assertEquals(birthDate, author.getBirthDate());
        assertEquals(deathDate, author.getDeathDate());
	}
}
