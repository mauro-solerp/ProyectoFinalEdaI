package gradle.cliapp.with.lib.template;

import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.exception.DuplicatedKeyException;
import gradle.cliapp.with.lib.template.exception.KeyNotFoundException;
import gradle.cliapp.with.lib.template.structures.MapData;
import gradle.cliapp.with.lib.template.utilities.Hash;
import org.junit.jupiter.api.*;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CacheTest {
    private String collection = "tests";

    @AfterAll
    void removeDirectory(){
        new File("persistentFiles\\"+Hash.hashCode(collection)).delete();
        new File("persistentFiles").delete();
    }
    @Test
    void testAddData() throws DuplicatedKeyException {
        Cache cache = new Cache(collection);
        cache.addNew("key", "value");
        assertNotNull(cache.get("key"));
        cache.remove("key");
    }

    @Test
    void testAddDataWithSpaces() throws DuplicatedKeyException {
        Cache cache = new Cache(collection);
        cache.addNew("key with spaces", "value");
        assertNotNull(cache.get("key with spaces"));
        cache.remove("key with spaces");
    }

    @Test
    void testAddDataWithDuplicatedKey() throws DuplicatedKeyException {
        Cache cache = new Cache(collection);
        cache.addNew("key", "value");
        assertThrows(DuplicatedKeyException.class, () -> cache.addNew("key", "value"));
        cache.remove("key");
    }

    @Test
    void testGetData() throws KeyNotFoundException, DuplicatedKeyException {
        Cache cache = new Cache(collection);
        cache.addNew("key", "value");
        assertEquals("value", cache.get("key"));
        cache.remove("key");
    }

    @Test
    void testGetDataWithSpaces() throws DuplicatedKeyException, KeyNotFoundException {
        Cache cache = new Cache(collection);
        cache.addNew("key with spaces", "value");
        assertEquals("value", cache.get("key with spaces"));
        cache.remove("key with spaces");
    }

    @Test
    void testGetDataWithKeyNotFound() {
        Cache cache = new Cache(collection);
        assertThrows(KeyNotFoundException.class, () -> cache.get("key"));
    }

    @Test
    void testDeleteData() throws DuplicatedKeyException, KeyNotFoundException {
        Cache cache = new Cache(collection);
        cache.addNew("key", "value");
        assertEquals("value", cache.get("key"));
        cache.remove("key");
        assertThrows(KeyNotFoundException.class, () -> cache.get("key"));
    }

    @Test
    void testDeleteDataWithSpaces() throws DuplicatedKeyException, KeyNotFoundException {
        Cache cache = new Cache(collection);
        cache.addNew("key with spaces", "value");
        assertEquals("value", cache.get("key with spaces"));
        cache.remove("key with spaces");
        assertThrows(KeyNotFoundException.class, () -> cache.get("key with spaces"));
    }

    @Test
    void testDeleteDataWithKeyNotFound() {
        Cache cache = new Cache(collection);
        assertThrows(KeyNotFoundException.class, () -> cache.remove("key"));
    }

    @Test
    void testPutNotExistingKey(){
        Cache cache = new Cache(collection);
        cache.put("key", "value");
        assertEquals("value", cache.get("key"));
        cache.remove("key");
    }

    @Test
    void testPutExistingKey(){
        Cache cache = new Cache(collection);
        cache.put("key with spaces", "value");
        cache.put("key with spaces", "value2");
        assertEquals("value2", cache.get("key with spaces"));
        cache.remove("key with spaces");
    }

    @Test
    void testSize(){
        Cache cache = new Cache(collection);
        cache.put("key", "value");
        cache.put("key2", "value2");
        assertEquals(2, cache.size());
        cache.remove("key");
        cache.remove("key2");
    }

    @Test
    void testExists(){
        Cache cache = new Cache(collection);
        cache.put("key", "value");
        assertTrue(cache.exists("key"));
        cache.remove("key");
    }

    @Test
    void getAll(){
        Cache cache = new Cache(collection);
        cache.put("key", "value");
        cache.put("key2", "value2");
        String[] data = cache.getAll();
        assertEquals(2, data.length);
        assertEquals("key", data[1]);
        assertEquals("key2", data[0]);
        cache.remove("key");
        cache.remove("key2");
    }

    @Test
    void testGetOrDefaultExistingKey(){
        Cache cache = new Cache(collection);
        cache.put("key", "value");
        assertEquals("value", cache.getOrDefault("key", "default"));
        cache.remove("key");
    }

    @Test
    void testGetOrDefaultNotExistingKey() {
        Cache cache = new Cache(collection);
        assertEquals("default", cache.getOrDefault("key", "default"));
    }

}
