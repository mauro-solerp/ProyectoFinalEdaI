package gradle.cliapp.with.lib.template.structures;
import static org.junit.jupiter.api.Assertions.*;

import gradle.cliapp.with.lib.template.exception.DuplicatedKeyException;
import org.junit.jupiter.api.*;

public class NodeMapTest {
    NodeMap nodeMap;

    @BeforeEach
    void setUp() {
        nodeMap = new NodeMap();
    }

    @Test
    void testInsert() throws DuplicatedKeyException {
        nodeMap.insert("key", "value");
        assertEquals("value", nodeMap.get("key").getValue());
    }

    @Test
    void testInsertDuplicateKey() throws DuplicatedKeyException {
        nodeMap.insert("key", "value 1");
        assertThrows(DuplicatedKeyException.class, () -> nodeMap.insert("key", "value 2"));
        assertEquals("value 1", nodeMap.get("key").getValue());
    }

    @Test
    void testInsertWithKeyWithSpaces() throws DuplicatedKeyException {
        nodeMap.insert("key with spaces", "value");
        assertEquals("value", nodeMap.get("key with spaces").getValue());
    }

    @Test
    void testInsertWithValueWithSpaces() throws DuplicatedKeyException {
        nodeMap.insert("key", "value with spaces");
        assertEquals("value with spaces", nodeMap.get("key").getValue());
    }

    @Test
    void testInsertWithKeyWithSpacesAndValueWithSpaces() throws DuplicatedKeyException {
        nodeMap.insert("key with spaces", "value with spaces");
        assertEquals("value with spaces", nodeMap.get("key with spaces").getValue());
    }

    @Test
    void testGetHead() {
        assertNull(nodeMap.getHead());
    }

    @Test
    void testSetHead() {
        Node<MapData> head = new Node<>(new MapData("key", "value"));
        nodeMap.setHead(head);
        assertEquals(head, nodeMap.getHead());
    }

    @Test
    void testSize() {
        assertEquals(0, nodeMap.size());
    }

    @Test
    void testRemove() throws DuplicatedKeyException {
        nodeMap.insert("key", "value");
        assertTrue(nodeMap.remove("key"));
        assertFalse(nodeMap.remove("key"));
        assertNull(nodeMap.get("key"));
    }

    @Test
    void testRemoveWithKeyWithSpaces() throws DuplicatedKeyException {
        nodeMap.insert("key with spaces", "value");
        assertTrue(nodeMap.remove("key with spaces"));
        assertFalse(nodeMap.remove("key with spaces"));
        assertNull(nodeMap.get("key with spaces"));
    }

    @Test
    void testContainsKey() throws DuplicatedKeyException {
        nodeMap.insert("key", "value");
        assertTrue(nodeMap.containsKey("key"));
        assertFalse(nodeMap.containsKey("key2"));
    }

    @Test
    void testPut() {
        nodeMap.put("key", "value");
        nodeMap.put("key", "value2");
        assertEquals("value2", nodeMap.get("key").getValue());
    }

    @Test
    void testKeys() {
        nodeMap.put("key1", "value1");
        nodeMap.put("key2", "value2");
        nodeMap.put("key3", "value3");
        String[] keys = nodeMap.keys();
        assertEquals("key3", keys[0]);
        assertEquals("key2", keys[1]);
        assertEquals("key1", keys[2]);
    }

}
