package Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<T> clazz, int size) {
        stack = (T[]) Array.newInstance(clazz, size);
        this.size = 0;
    }

    @Override
    public void push(T data) {
        if (size < stack.length) {
            stack[size++] = data;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    @Override
    public T pop() {
        if (size > 0) {
            T value = stack[--size];
            stack[size] = null; // Avoid memory leak
            return value;
        } else {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    @Override
    public T peek() {
        if (size > 0) {
            return stack[size - 1];
        } else {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == stack.length;
    }

    @Override
    public void display() {
        System.out.println(Arrays.toString(Arrays.copyOf(stack, size)));
    }
}
