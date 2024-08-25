package linkedlist.single;

import linkedlist.List;


public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". Index must be between 0 and " + size + ".");
        } else {
            Node<T> temp = head;
            if(index == 0) {
                return temp.data;
            }
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Invalid index: " + index + ". Index must be between 0 and " + size + ".");
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
        size++;
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Invalid index: " + index + ". Index must be between 0 and " + (size - 1) + ".");
        }

        if (index == 0) {
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
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


    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

}










