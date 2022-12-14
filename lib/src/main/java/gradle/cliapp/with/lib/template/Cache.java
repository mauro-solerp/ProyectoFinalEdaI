/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle.cliapp.with.lib.template;

import gradle.cliapp.with.lib.template.exception.*;
import gradle.cliapp.with.lib.template.structures.MapData;
import gradle.cliapp.with.lib.template.structures.NodeMap;
import gradle.cliapp.with.lib.template.utilities.Hash;
import gradle.cliapp.with.lib.template.utilities.UtilsFile;

/**
 * Cache class
 */
public class Cache implements ICache {

    /**
     * data of the cache
     */
    private NodeMap data;

    /**
     * directory of persistent files of the cache
     */
    private final String dir;

    /**
     * Create a new cache
     * @param collection collection of the cache
     */
    public Cache(String collection) {
        dir =  "persistentFiles\\" + Hash.hashCode(collection);
        try {
            data = new NodeMap();
            MapData[] data = UtilsFile.readFiles(dir);
            for (MapData mapData : data) {
                this.data.insert(mapData.getKey(), mapData.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Count the keys (and values) stored in cache.
     * @return Count of keys.
     */
    public int size() {
        return data.size();
    }

    /**
     * Get all keys stored in cache.
     * @return array of stored keys
     */
    public String[] getAll() {
        return data.keys();
    }

    /**
     * Get the value associated with the key passed as argument.
     * @param key Key to look for
     * @return The value associated with the key
     * @throws KeyNotFoundException if key does not exist.
     */
    public String get(String key) throws KeyNotFoundException {
        if (this.exists(key)) {
            return data.get(key).getValue();
        } else {
            throw new KeyNotFoundException();
        }
    }

    /**
     * Return the value of key passed as argument. Otherwise, return the
     * default value passed as second argument.
     * @param key Key to look for
     * @param defaultValue Value returned when key does not exist.
     * @return The value associated with the key or the defaultValue if key was not
    found.
     */
    public String getOrDefault(String key, String defaultValue) {
            if(data.get(key) != null){
                return data.get(key).getValue();
            } else {
                return defaultValue;
            }
    }

    /**
     * Check is a key exists in cache.
     * @param key Key to look for
     * @return True if key exists.
     */
    public boolean exists(String key) {
        return data.containsKey(key);
    }

    /**
     * Add or update the value associated to a key.
     * @param key Key to be stored.
     * @param value Value to be stored.
     */
    public void put(String key, String value) {
        data.put(key, value);
        UtilsFile.writeFile(new MapData(key, value), dir);
    }

    /**
     * Add a value to a new key. If key already exists, it throws an exception.
     * @param key Key to be stored.
     * @param value Value to be stored.
     * @throws DuplicatedKeyException the key already exists.
     */
    public void addNew(String key, String value) throws DuplicatedKeyException {
        if (this.exists(key)) {
            throw new DuplicatedKeyException();
        } else {
            data.insert(key, value);
            UtilsFile.writeFile(new MapData(key, value), dir);
        }
    }

    /**
     * Remove a key and its value.
     *
     * @param key Key to be stored.
     * @throws KeyNotFoundException if key does not exist.
     */
    public void remove(String key) throws KeyNotFoundException {
        if (this.exists(key)) {
           data.remove(key);
            UtilsFile.deleteFile(dir, key);
        } else {
            throw new KeyNotFoundException();
        }
    }
}
