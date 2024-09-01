package linkedlist.doublelinkedlist;

public  class DoubleNode<T> {
    T data;
    DoubleNode<T> next;
    DoubleNode<T> previous;

    public DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
