package code.basic.list;

import java.util.Arrays;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    private Object[] array;

    public MyArrayList(int initCapacity) {
        array = new Object[initCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        return (E) array[index];
    }

    public void set(int index, E item) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        array[index] = item;
    }

    public void add(E item) {
        if(array.length == size) growCapacity();
        array[size++] = item;
    }

    public void insert(int index, E item) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        if(array.length == size) growCapacity();
        int copyLength = size - index;
        System.arraycopy(array, index, array, index + 1, copyLength);
        array[index] = item;
        size++;
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size : %d, Index : %d", size, index));
        }
        E item = (E) array[index];
        int copyLength = size - index - 1;
        System.arraycopy(array, index + 1, array, index, copyLength);
        size--;
        return item;
    }

    private void growCapacity() {
        array = Arrays.copyOf(array, array.length + (array.length >> 1));
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
            "array=" + Arrays.toString(array) +
            '}';
    }
}
