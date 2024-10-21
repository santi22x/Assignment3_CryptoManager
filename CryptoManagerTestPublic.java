
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestPublic {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("JAVA"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("java"));
		assertFalse(CryptoManager.isStringInBounds("{JAVA"));
		assertFalse(CryptoManager.isStringInBounds("INVALID CHARACTERS LIKE [ AND ]"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("invalid", 5));
        assertEquals("BCD", CryptoManager.caesarEncryption("ABC", 1));
        assertEquals("%&'", CryptoManager.caesarEncryption("ABC", 90));
        assertEquals("#$%", CryptoManager.caesarEncryption("XYZ", 5));
        assertEquals("MJQQT", CryptoManager.caesarEncryption("HELLO", 5));
        assertEquals("DWWDFNLQJ", CryptoManager.caesarEncryption("ATTACKING", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO", CryptoManager.caesarDecryption("MJQQT", 5));
        assertEquals("XYZ", CryptoManager.caesarDecryption("#$%", 5));
        assertEquals("ATTACKING", CryptoManager.caesarDecryption("DWWDFNLQJ", 3));
        assertEquals("WORLD", CryptoManager.caesarDecryption("TPQMD", 10));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WQRRN#", CryptoManager.bellasoEncryption("TESTER", "CODE"));
        assertEquals("ZU@W*VRB^", CryptoManager.bellasoEncryption("STUDENT", "KEY"));
        assertEquals("!A!%#!'!+", CryptoManager.bellasoEncryption("SAMPLE TEST", "KEYLONGER"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTER", CryptoManager.bellasoDecryption("WQRRN#", "CODE"));
        assertEquals("STUDENT", CryptoManager.bellasoDecryption("ZU@W*VRB^", "KEY"));
        assertEquals("SAMPLE TEST", CryptoManager.bellasoDecryption("!A!%#!'!+", "KEYLONGER"));

	}

}

