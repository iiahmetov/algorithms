package Lesson_3;

import java.util.NoSuchElementException;

public class MyArrayDeque <Item> {
    private Object[] deque = new Object[1];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    private void resize (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp [i] = deque[(i + head)% deque.length];
        }
        deque = temp;
        head = 0;
        tail = size-1;
    }

    public void pushTail (Item item){
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        tail = (tail + 1) % deque.length;
        deque[tail] = item;
        size++;
    }

    public void pushHead (Item item){
        if (size == deque.length) {
            resize(deque.length * 2);
        }
        head = (deque.length + head - 1) % deque.length;
        deque[head] = item;
        size++;
    }

    public Item popHead(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        Item temp = (Item) deque[head];
        deque[head] = null;
        head = (head + 1) % deque.length;
        size--;
        if (size == deque.length/4 && size > 0) {
            resize(deque.length / 2);
        }
        return temp;
    }

    public Item popTail(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        Item temp = (Item) deque[tail];
        deque[tail] = null;
        tail = (deque.length + tail - 1) % deque.length;
        size--;
        if (size == deque.length/4 && size > 0) {
            resize(deque.length / 2);
        }
        return temp;
    }

    public Item peekHead(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return (Item) deque[head];
    }

    public Item peekTail(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return (Item) deque[tail];
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deque[(i + head)% deque.length] +  ", ");
        }
        return s.toString();
    }

}
