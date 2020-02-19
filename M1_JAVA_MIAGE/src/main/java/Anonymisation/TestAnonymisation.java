package Anonymisation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

public class TestAnonymisation {

	
	@Test
	public void testDifferentStringsRLStrategy() {
		String str = "LE GUEN";
		// IAnonymisation testRandomStrat = new RANDOM_LETTER_STRATEGY();
		assertNotEquals(str, Anonymisation.anonymiseFull(str));
		//assertNo
	
	}

	@Test
	public void testSameSizeRLStrategy() {
		String str = "LE GUEN";

		assertEquals(str.length(), Anonymisation.anonymiseFull(str).length());
	}

	@Test
	public void testDifferentStringsRLLocalPartStrategy() {
		String str = "yannis.le-guen@hotmail.fr";
	 assertNotEquals(str, Anonymisation.anonymiseForLocalPart(str));
	}

	@Test
	public void testSameSizeRLLocalStrategy() {
		String str = "yannis.le-guen@hotmail.fr";
		assertEquals(str.length(), Anonymisation.anonymiseForLocalPart(str).length());

	}

}
