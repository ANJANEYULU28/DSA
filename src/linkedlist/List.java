package linkedlist;

public interface List<T> {
    public void add(T data);
    public void add(int index, T data);
    public T get(int index);
    public void remove(int index);
    public int size();
    public boolean isEmpty();
    public void clear();
}
