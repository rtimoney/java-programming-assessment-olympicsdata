/**
 * 
 */
package olympics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * RONAN TIMONEY
 * 40103299
 *
 */
class MedalTest {
	
	Medal mc;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mc= new Medal(2222,"Test City", "Test Sport", "Test Discipline", "Test Name", "AAA", "Male", "Test Event","Gold");
		
	}


	/**
	 * Test method for {@link olympics.MedalTest#getYear()}.
	 */
	@Test
	final void testGetYear() {
		int expected = 2222;
		int actual = mc.getYear();
		assertEquals(expected,actual);
		System.out.println(mc.getYear());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setYear(int)}.
	 */
	@Test
	final void testSetYear() {
		int expected = 1993;
		int actual = mc.setYear(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getYear());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getCountry()}.
	 */
	@Test
	final void testGetCountry() {
		String expected = "AAA";
		String actual = mc.getCountry();
		assertEquals(expected,actual);
		System.out.println(mc.getCountry());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setCountry(java.lang.String)}.
	 */
	@Test
	final void testSetCountry() {
	    String expected = "ZZZ";
		String actual = mc.setCountry(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getCountry());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getAthlete()}.
	 */
	@Test
	final void testGetAthlete() {
		String expected = "Test Name";
		String actual = mc.getAthlete();
		assertEquals(expected,actual);
		System.out.println(mc.getAthlete());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setAthlete(java.lang.String)}.
	 */
	@Test
	final void testSetAthlete() {
		String expected = "Usain Bolt";
		String actual = mc.setAthlete(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getAthlete());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getCity()}.
	 */
	@Test
	final void testGetCity() {
		String expected = "Test City";
		String actual = mc.getCity();
		assertEquals(expected,actual);
		System.out.println(mc.getCity());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setCity(java.lang.String)}.
	 */
	@Test
	final void testSetCity() {
		String expected = "Atlantis";
		String actual = mc.setCity(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getCity());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getSport()}.
	 */
	@Test
	final void testGetSport() {
		String expected = "Test Sport";
		String actual = mc.getSport();
		assertEquals(expected,actual);
		System.out.println(mc.getSport());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setSport(java.lang.String)}.
	 */
	@Test
	final void testSetSport() {
		String expected = "New Sport";
		String actual = mc.setSport(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getSport());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getDiscipline()}.
	 */
	@Test
	final void testGetDiscipline() {
		String expected = "Test Discipline";
		String actual = mc.getDiscipline();
		assertEquals(expected,actual);
		System.out.println(mc.getDiscipline());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setDiscipline(java.lang.String)}.
	 */
	@Test
	final void testSetDiscipline() {
		String expected = "New Discipline";
		String actual = mc.setDiscipline(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getDiscipline());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getGender()}.
	 */
	@Test
	final void testGetGender() {
		String expected = "Male";
		String actual = mc.getGender();
		assertEquals(expected,actual);
		System.out.println(mc.getGender());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setGender(java.lang.String)}.
	 */
	@Test
	final void testSetGender() {
		String expected = "Female";
		String actual = mc.setGender(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getGender());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getEvent()}.
	 */
	@Test
	final void testGetEvent() {
		String expected = "Test Event";
		String actual = mc.getEvent();
		assertEquals(expected,actual);
		System.out.println(mc.getEvent());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setEvent(java.lang.String)}.
	 */
	@Test
	final void testSetEvent() {
		String expected = "New Event";
		String actual = mc.setEvent(expected);
		assertEquals(expected,actual);
		System.out.println(mc.getEvent());
	}

	/**
	 * Test method for {@link olympics.MedalTest#getMedal()}.
	 */
	@Test
	final void testGetMedal() {
		String expected = "Gold";
		String actual = mc.getMedal();
		assertEquals(expected,actual);
		System.out.println(mc.getMedal());
	}

	/**
	 * Test method for {@link olympics.MedalTest#setMedal(int)}.
	 */
	@Test
	final void testSetMedal() {
		String expected = "Silver";
		String actual = mc.setMedal(2);
		assertEquals(expected,actual);
		System.out.println(mc.getMedal());
	}

}
