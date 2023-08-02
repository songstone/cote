package code.basic.list;

public class MyLinkedList<E> {

    private int size = 0;
    private Node<E> first = null;
    private Node<E> last = null;

    public void addFirst(E data) {
        Node<E> node = new Node<>(data, first);
        if(size == 0) last = node;
        first = node;
        size++;
    }

    public void add(E data) {
        Node<E> node = new Node<>(data, null);
        if (size == 0) first = node;
        else last.next = node;
        last = node;
        size++;
    }

    public void insert(Node<E> prevNode, E data) {
        Node<E> node = new Node<>(data, prevNode.next);
        prevNode.next = node;
        if(node.next == null) last = node;
        size++;
    }

    public void insert(int index, E data) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        if(index == 0) addFirst(data);
        else if(index == size) add(data);
        else insert(getNode(index - 1), data);
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        if(index == 0) removeFirst();
        else removeNext(getNode(index - 1));
    }

    private void removeFirst() {
        if (first != null) {
            first = first.next;
            if(first == null) last = null;
            size--;
        }
    }

    private void removeNext(Node<E> prevNode) {
        if (prevNode != null) {
            prevNode.next = prevNode.next.next;
            if(prevNode.next == null) last = prevNode;
            size--;
        }
    }

    private Node<E> getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        Node<E> node = first;
        while (index-- > 0) {
            node = node.next;
        }
        return node;
    }

    public static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
