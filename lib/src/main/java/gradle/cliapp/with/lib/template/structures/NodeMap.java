package gradle.cliapp.with.lib.template.structures;

import gradle.cliapp.with.lib.template.exception.DuplicatedKeyException;

public class NodeMap {
    /**
     * The head of the node map
     */
    private Node<MapData> head;

    /**
     * Create a new node map
     */
    public NodeMap() {
        head = null;
    }

    /**
     * Get the head of the node map
     * @return head
     */
    public Node<MapData> getHead() {
        return head;
    }

    /**
     * Set the head of the node map
     * @param head head to set
     */
    public void setHead(Node<MapData> head) {
        this.head = head;
    }

    /**
     * Get the size of the node map
     * @return size
     */
    public int size() {
        if (head == null) {
            return 0;
        }
        return head.count();
    }

    /**
     * Add a new map data to the node map
     * @param key   key of the map data
     * @param value value of the map data
     * @throws DuplicatedKeyException if the key already exists
     */
    public MapData insert(String key, String value) throws DuplicatedKeyException {
        if (this.containsKey(key)) {
            throw new DuplicatedKeyException();
        }
        MapData mapData = new MapData(key, value);
        Node<MapData> newNode = new Node<>(mapData);
        if (head != null) {
            newNode.setNext(head);
        }
        setHead(newNode);
        return mapData;
    }

    /**
     * Get the map data by key
     * @param key key of the map data
     * @return map data
     */
    public MapData get(String key) {
        Node<MapData> current = head;
        while (current != null) {
            if (current.getData().compareTo(new MapData(key,null)) == 0) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Remove the map data by key
     * @param key key of the map data
     */
    public boolean remove(String key) {
        Node<MapData> current = head;
        Node<MapData> previous = null;
        while (current != null) {
            if (current.getData().compareTo(new MapData(key,null)) == 0) {
                if (previous == null) {
                    setHead(current.getNext());
                } else {
                    previous.setNext(current.getNext());
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    /**
     * update value of the map data by key
     * @param key key of the map data
     * @param value value of the map data
     * @throws DuplicatedKeyException if the key already exists
     * @return map data updated
     */
    public MapData put(String key, String value) {
        try {
            if (this.containsKey(key)){
                MapData mapData = this.get(key);
                mapData.setValue(value);
                return mapData;
            } else {
                return (this.insert(key, value));
            }
        } catch (DuplicatedKeyException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Check if the node map contains the key
     * @param key key of the map data
     * @return true if the node map contains the key
     */
    public boolean containsKey(String key) {
        Node<MapData> current = head;
        while (current != null) {
            if (current.getData().compareTo(new MapData(key, null)) == 0) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * get keys
     * @return Object of keys string
     */
    public String[] keys() {
        String[] keys = new String[this.size()];
        Node<MapData> current = head;
        int i = 0;
        while (current != null) {
            keys[i] = current.getData().getKey();
            current = current.getNext();
            i++;
        }
        return keys;
    }




}
