package gradle.cliapp.with.lib.template.structures;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class NodeTest {
    private Node<MapData> node;

    @BeforeEach
    void setUp() {
        node = new Node(new MapData("key", "value"));
    }

    @Test
    void testGetData() {
        assertEquals("key", node.getData().getKey());
        assertEquals("value", node.getData().getValue());
    }

    @Test
    void testSetData() {
        node.setData(new MapData("key2", "value2"));
        assertEquals("key2", node.getData().getKey());
        assertEquals("value2", node.getData().getValue());
    }

    @Test
    void testGetNext() {
        assertNull(node.getNext());
    }

    @Test
    void testSetNext() {
        Node<MapData> next = new Node(new MapData("key2", "value2"));
        node.setNext(next);
        assertEquals(next, node.getNext());
    }

    @Test
    void testCount() {
        assertEquals(1, node.count());
    }




}
