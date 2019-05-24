package Lesson_3;

import java.util.NoSuchElementException;

public class MyArrayQueue <Item> {
    private Object[] queue = new Object[1];
    private int start = 0;
    private int end = 0;
    private int size = 0;

    public int size (){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize (int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(i + start) % queue.length];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    public void Enqueue (Item item){
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        queue[end] = item;
        end = (end + 1) % queue.length;
        size++;
    }

    public Item Dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        Item temp = (Item) queue[start];
        queue[start] = null;
        size--;
        start = (start+1) % queue.length;
        if (size == queue.length/4 && size > 0) {
            resize(queue.length/2);
        }
        return temp;
    }

    public Item peekFront(){
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return (Item) queue[start];
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(queue[(i + start)% queue.length] +  ", ");
        }
        return s.toString();
    }
}
