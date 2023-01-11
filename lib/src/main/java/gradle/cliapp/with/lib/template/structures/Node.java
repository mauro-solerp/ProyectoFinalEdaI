package gradle.cliapp.with.lib.template.structures;

public class Node<T> {
    /**
     * The data of the node
     */
    private T data;
    /**
     * The next node
     */
    private Node<T> next;

    /**
     * Create a new node
     * @param data data of the node
     */
    public Node(T data) {
        setData(data);
    }
    /**
     * Get the data of the node
     * @return data
     */
    public T getData() {
        return data;
    }
    /**
     * Set the data of the node
     * @param data data to set
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * Get the next node
     * @return next node
     */
    public Node<T> getNext() {
        return next;
    }
    /**
     * Set the next node
     * @param next next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * count the number of nodes
     * @return number of nodes
     */
    public int count() {
        if (getNext() == null) {
            return 1;
        } else {
            return 1 + getNext().count();
        }
    }
}