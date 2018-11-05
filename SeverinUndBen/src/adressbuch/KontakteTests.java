package adressbuch;

import org.junit.Test;

public class KontakteTests {
	
	AdressbuchMethoden AdressbuchMethoden = new AdressbuchMethoden();
	private Person createTestArrange() {
		Person testPerson = new Person();
		testPerson.setVorname("Severin");
		testPerson.setNachname("Nauer");
		testPerson.setAlter("17");
		testPerson.setEmail("SeverinNauer@hotmail.com");
		testPerson.setTelefonnummer("0791876988");
		testPerson.setGeschlecht("Männlich");
		testPerson.setOrt("Einsiedeln");
		testPerson.setStrasse("Bergliweg 6");
		return testPerson;
		
	}
	
	@Test
	public void positiveTestCheckVorname() {
		Person p = new Person();
		p = createTestArrange();
		AssertTrue(p.getVorname().equals("Severin"));
	}
	
	@Test
	public void positiveTestCheckNachname() {
		Person p = new Person();
		p = createTestArrange();
		AssertTrue(p.getNachname().equals("Nauer"));
	}
	
	@Test
	public void positiveTestCheckAlter() {
		Person p = new Person();
		p = createTestArrange();
		AssertTrue(p.getAlter().equals("17"));
	}
	
	@Test
	public void positiveTestCheckStrasse() {
		Person p = new Person();
		p = createTestArrange();
		AssertTrue(p.getStrasse().equals("Bergliweg 6"));
	}
	
	@Test
	public void positiveTestCheckEmail() {
		Person p = new Person();
		p = createTestArrange();
		AssertTrue(p.getEmail().equals("SeverinNauer@hotmail.com"));
	}
	
	@Test
	public void negativeTestCheckVorname() {
		Person p = new Person();
		p = createTestArrange();
		AssertFalse(p.getVorname().equals("Blub"));
	}

	@Test
	public void negativeTestCheckGeschlecht() {
		Person p = new Person();
		p = createTestArrange();
		AssertFalse(p.getGeschlecht().equals("Foo"));
	}
	
	@Test
	public void negativeTestCheckEmail() {
		Person p = new Person();
		p = createTestArrange();
		AssertFalse(p.getEmail().equals("Blub"));
	}
	
	@Test
	public void negativeTestCheckOrt() {
		Person p = new Person();
		p = createTestArrange();
		AssertFalse(p.getOrt().equals("Foo"));
	}

	private void AssertTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}
	private void AssertFalse(boolean equals) {
		// TODO Auto-generated method stub
		
	}
}
