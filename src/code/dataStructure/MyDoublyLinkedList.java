package code.dataStructure;

public class MyDoublyLinkedList<E> {
    private int size = 0;
    private Node<E> firstNode = null;
    private Node<E> lastNode = null;

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;
        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    private void addFirst(E element) {
        Node<E> newNode = new Node<>(null, element, firstNode);
        if (size == 0) lastNode = newNode;
        else firstNode.prev = newNode;
        firstNode = newNode;
        size++;
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(lastNode, element, null);
        if (size == 0) firstNode = newNode;
        else lastNode.next = newNode;
        lastNode = newNode;
        size++;
    }

    public Node<E> getNode(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        Node<E> currentNode = firstNode;
        for (int i = 0; i < idx; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public E get(int idx) {
        return getNode(idx).item;
    }

    public void set(int idx, E element) {
        Node<E> targetNode = getNode(idx);
        targetNode.item = element;
    }

    public void insert(Node<E> prevNode, E element) {
        Node<E> newNode = new Node(prevNode, element, prevNode.next);
        if (newNode.next != null) newNode.next.prev = newNode;
        prevNode.next = newNode;
        if (newNode.next == null)
            lastNode = newNode;
        size++;
    }

    public void insert(int idx, E element) {
        if (idx < 0 || idx > size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        if (idx == 0) addFirst(element);
        else if (idx == size) add(element);
        else insert(getNode(idx - 1), element);
    }

    public void remove(Node<E> targetNode) {
        if (targetNode.prev != null)
            targetNode.prev.next = targetNode.next;
        else firstNode = targetNode.next;

        if (targetNode.next != null)
            targetNode.next.prev = targetNode.prev;
        else lastNode = targetNode.prev;

        targetNode.item = null;
        targetNode.prev = targetNode.next = null;
        size--;
    }

    public void remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        remove(getNode(idx));
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public Node<E> getLastNode() {
        return lastNode;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> currentNode = firstNode;
        sb.append('[');
        for(int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(currentNode.item.toString());
            currentNode = currentNode.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
