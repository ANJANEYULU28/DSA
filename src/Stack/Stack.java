package Stack;

public interface Stack<T> {
    public void push(T data);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public boolean isFull();
    public void display();
}
