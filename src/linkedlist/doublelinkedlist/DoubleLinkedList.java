package linkedlist.doublelinkedlist;

import linkedlist.List;

public class DoubleLinkedList<T> implements List<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;


    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    private static class DoubleNode<T> {
        T data;
        DoubleNode<T> next;
        DoubleNode<T> previous;

        DoubleNode(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }


    @Override
    public void add(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be between 0 and " + size + ".");
        }

        DoubleNode<T> newNode = new DoubleNode<>(data);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.previous = newNode;
            }
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            DoubleNode<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.previous = newNode;
            temp.next = newNode;
            newNode.previous = temp;
        }

        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be between 0 and " + (size - 1) + ".");
        }

        DoubleNode<T> temp;
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }

        return temp.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be between 0 and " + (size - 1) + ".");
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            if (size == 1) {
                tail = null;
            }
        } else {
            DoubleNode<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.previous = temp;
            } else {
                tail = temp;
            }
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
