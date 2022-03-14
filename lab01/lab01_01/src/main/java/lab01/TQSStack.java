package lab01;

import java.util.LinkedList;

public class TQSStack<T> {

    private LinkedList<T> list;

    public TQSStack() {
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void push(T elem) {
        list.push(elem);
    }

    public T pop() throws NullPointerException {
        if(this.isEmpty()) {
            throw new NullPointerException();
        }
        return list.pop();
    }

    public T peek() throws NullPointerException {
        if(this.isEmpty()) {
            throw new NullPointerException();
        }
        return list.peek();
    }

}
