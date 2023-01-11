package gradle.cliapp.with.lib.template.structures;

import java.io.Serializable;

public class MapData implements Comparable<MapData>, Serializable {

    /**
     * key of the map data
     */
    private String key;
    /**
     * value of the map data
     */
    private String value;
    /**
     * Create a new map data
     * @param key   key of the map data
     * @param value value of the map data
     */
    public MapData(String key, String value) {
        this.key = key;
        this.value = value;
    }


    /**
     * Get the key of the map data
     * @return key of the map data
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the key of the map data
     * @param key key to set to the map data
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get the value of the entry
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of the map data
     * @param val value to set to the map data
     */
    public void setValue(String val) {
        this.value = val;
    }

    /**
     * Compare the map data with another map data
     *
     * @param o other map data
     * @return 0 if equal, 1 if greater, -1 if less
     */
    @Override
    public int compareTo(MapData o) {
        return this.key.compareTo(o.key);
    }
}
