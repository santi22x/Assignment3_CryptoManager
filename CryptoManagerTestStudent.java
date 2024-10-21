import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
        assertTrue(CryptoManager.isStringInBounds("12345!@#$%"));
        assertFalse(CryptoManager.isStringInBounds("hello"));
        assertFalse(CryptoManager.isStringInBounds("{TEST}"));
        assertFalse(CryptoManager.isStringInBounds("SPECIAL{CHAR}"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hello", 5));
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
        assertEquals("!\"#$", CryptoManager.caesarEncryption(" !\"#", 1));
        assertEquals("EFGHI", CryptoManager.caesarEncryption("ABCDE", 4));
        assertEquals("YZ[\\", CryptoManager.caesarEncryption("WXYZ", 2));
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
        assertEquals(" !\"#", CryptoManager.caesarDecryption("!\"#$", 1));
        assertEquals("ABCDE", CryptoManager.caesarDecryption("EFGHI", 4));
        assertEquals("WXYZ", CryptoManager.caesarDecryption("YZ[\\", 2));
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("_T^XS8", CryptoManager.bellasoEncryption("HELLO!", "WORLD"));
        assertEquals("\"B&(*$-", CryptoManager.bellasoEncryption("ABCDEFG", "!@#$%^&"));
        assertEquals("\"]2%", CryptoManager.bellasoEncryption("WXYZ", "KEY"));
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("HELLO!", CryptoManager.bellasoDecryption("_T^XS8", "WORLD"));
        assertEquals("ABCDEFG", CryptoManager.bellasoDecryption("\"B&(*$-", "!@#$%^&"));
        assertEquals("WXYZ", CryptoManager.bellasoDecryption("\"]2%", "KEY"));
    }
}
