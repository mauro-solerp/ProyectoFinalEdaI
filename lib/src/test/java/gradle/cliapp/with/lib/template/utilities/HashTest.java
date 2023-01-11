package gradle.cliapp.with.lib.template.utilities;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
public class HashTest {
    @Test
    void testHashAString() {
        String string = "Hello World";
        String hash = Hash.hashCode(string);
        assertEquals("cc969a84", hash);
    }

    @Test
    void testHashAStringWithSpaces() {
        String string = "Hello World with spaces";
        String hash = Hash.hashCode(string);
        assertEquals("918b3d2b", hash);
    }
}
