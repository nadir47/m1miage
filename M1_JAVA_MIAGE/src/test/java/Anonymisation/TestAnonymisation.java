package Anonymisation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.Test;

import anonymisation.AllAnonymisationRules;

public class TestAnonymisation {

	
	@Test
	public void testDifferentStringsRLStrategy() {
		String str = "LE GUEN";
		// IAnonymisation testRandomStrat = new RANDOM_LETTER_STRATEGY();
		assertNotEquals(str, AllAnonymisationRules.anonymiseFull(str));
		//assertNo
	
	}

	@Test
	public void testSameSizeRLStrategy() {
		String str = "LE GUEN";

		assertEquals(str.length(), AllAnonymisationRules.anonymiseFull(str).length());
	}

	@Test
	public void testDifferentStringsRLLocalPartStrategy() {
		String str = "yannis.le-guen@hotmail.fr";
	 assertNotEquals(str, AllAnonymisationRules.anonymiseForLocalPart(str));
	}

	@Test
	public void testSameSizeRLLocalStrategy() {
		String str = "yannis.le-guen@hotmail.fr";
		assertEquals(str.length(), AllAnonymisationRules.anonymiseForLocalPart(str).length());

	}

}
