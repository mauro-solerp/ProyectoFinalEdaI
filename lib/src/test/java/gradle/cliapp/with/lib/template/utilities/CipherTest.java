package gradle.cliapp.with.lib.template.utilities;
import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.structures.MapData;
import org.junit.jupiter.api.*;

import java.io.File;

public class CipherTest {
    @Test
    void testEncryptAndDesencryptInformation() {
        Cipher.encryptFile(new MapData("key", "value"), new File("TxtEncripted.txt"));
        assertTrue(new File("TxtEncripted.txt").exists());
        MapData mapData = Cipher.decryptFile(new File("TxtEncripted.txt"));
        assertEquals("key", mapData.getKey());
        assertEquals("value", mapData.getValue());
        new File("TxtEncripted.txt").delete();
    }
}
