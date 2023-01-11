package gradle.cliapp.with.lib.template.structures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MapDataTest {
    @Test
    void testMapData() {
        MapData mapData = new MapData("key", "value");
        assertEquals("key", mapData.getKey());
        assertEquals("value", mapData.getValue());
    }
    @Test
    void testMapDataWithKeyWithSpaces() {
        MapData mapData = new MapData("key with spaces", "value");
        assertEquals("key with spaces", mapData.getKey());
        assertEquals("value", mapData.getValue());
    }
    @Test
    void testMapDataWithValueWithSpaces() {
        MapData mapData = new MapData("key", "value with spaces");
        assertEquals("key", mapData.getKey());
        assertEquals("value with spaces", mapData.getValue());
    }
    @Test
    void testMapDataWithKeyWithSpacesAndValueWithSpaces() {
        MapData mapData = new MapData("key with spaces", "value with spaces");
        assertEquals("key with spaces", mapData.getKey());
        assertEquals("value with spaces", mapData.getValue());
    }
    @Test
    void testMapDataWithKeyWithSpacesAndValueWithSpacesAndTabs() {
        MapData mapData = new MapData("key with spaces", "value with spaces and tabs");
        assertEquals("key with spaces", mapData.getKey());
        assertEquals("value with spaces and tabs", mapData.getValue());
    }
    @Test
    void testMapDataWithKeyWithSpacesAndValueWithSpacesAndTabsAndNewLines() {
        MapData mapData = new MapData("key with spaces", "value with spaces and tabs and new lines and more");
        assertEquals("key with spaces", mapData.getKey());
        assertEquals("value with spaces and tabs and new lines and more", mapData.getValue());
    }
}
