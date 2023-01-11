package gradle.cliapp.with.lib.template.utilities;

import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.structures.MapData;
import org.junit.jupiter.api.*;

import java.io.File;

public class UtilsFileTest {
    @Test
    void testWriteFile() {
        UtilsFile.writeFile(new MapData("key", "value"), "tests");
        assertTrue(new File("tests\\" + Hash.hashCode("key") + ".txt").exists());
        MapData[] data = UtilsFile.readFiles("tests");
        assertEquals("key", data[0].getKey());
        assertEquals("value", data[0].getValue());
        new File("tests\\" + Hash.hashCode("key") + ".txt").delete();
    }

    @Test
    void testWriteFileWithKeyWithSpaces() {
        UtilsFile.writeFile(new MapData("key with spaces", "value"), "tests");
        assertTrue(new File("tests\\" + Hash.hashCode("key with spaces") + ".txt").exists());
        MapData[] data = UtilsFile.readFiles("tests");
        assertEquals("key with spaces", data[0].getKey());
        assertEquals("value", data[0].getValue());
        new File("tests\\" + Hash.hashCode("key with spaces") + ".txt").delete();
    }

    @Test
    void testWriteFileWithValueWithSpaces() {
        UtilsFile.writeFile(new MapData("key", "value with spaces"), "tests");
        assertTrue(new File("tests\\" + Hash.hashCode("key") + ".txt").exists());
        MapData[] data = UtilsFile.readFiles("tests");
        assertEquals("key", data[0].getKey());
        assertEquals("value with spaces", data[0].getValue());
        new File("tests\\" + Hash.hashCode("key") + ".txt").delete();
        new File("tests").delete();
    }

    @Test
    void testReadFiles(){
        UtilsFile.writeFile(new MapData("key", "value"), "tests");
        UtilsFile.writeFile(new MapData("key2", "value2"), "tests");
        UtilsFile.writeFile(new MapData("key3", "value3"), "tests");
        MapData[] data = UtilsFile.readFiles("tests");
        assertEquals("key", data[0].getKey());
        assertEquals("value", data[0].getValue());
        assertEquals("key2", data[1].getKey());
        assertEquals("value2", data[1].getValue());
        assertEquals("key3", data[2].getKey());
        assertEquals("value3", data[2].getValue());
        new File("tests\\" + Hash.hashCode("key") + ".txt").delete();
        new File("tests\\" + Hash.hashCode("key2") + ".txt").delete();
        new File("tests\\" + Hash.hashCode("key3") + ".txt").delete();
        new File("tests").delete();
    }

    @Test
    void testDeleteFile(){
        UtilsFile.writeFile(new MapData("key", "value"), "tests");
        UtilsFile.deleteFile("tests", "key");
        assertFalse(new File("tests\\" + Hash.hashCode("key")).exists());
        new File("tests").delete();
    }
}
