package Lesson_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <Item> implements Iterable<Item>{

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedIterator();
    }

    private class MyLinkedIterator implements Iterator <Item> {

        Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = cursor.item;
            cursor = cursor.next;
            return item;
        }
    }

    private class Node {
        Node previous;
        Item item;
        Node next;

        public Node (Node previous, Item item, Node next){
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private int size;
    private Node first = null;
    private Node last = null;

    public int size(){
        return size;
    }

    public  boolean isEmpty(){
        return (size == 0);
    }

    public Item getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return first.item;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node second = first.next;
        Item temp = first.item;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()){
            last = null;
        } else {
            first.previous = null;
        }
        return temp;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        size++;
        if (size == 1){
            last = first;
        } else {
            oldFirst.previous = first;
        }
    }

    public Item getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        return last.item;
    }

    public void addLast(Item item){
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        Item temp = last.item;
        Node previous = last.previous;
        last.previous = null;
        last = previous;
        size--;
        if (isEmpty()){
            first = null;
        } else {
            last.next = null;
        }
        return temp;
    }

    public Item get (int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        if (index >= size/2){                           //если индекс во второй половине, то идём по ссылкам с конца в начало
            Node currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index) {
                currentNode = currentNode.previous;
                currentIndex--;
            }
            return currentNode.item;
        } else {                                        //в противном случае идём по ссылкам с начала
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            return currentNode.item;
        }
    }

    public void set (int index, Item item) {
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        if (index >= size/2){                               //если индекс во второй половине списка, то идём по ссылкам с конца в начало
            Node currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index) {
                currentNode = currentNode.previous;
                currentIndex--;
            }
            currentNode.item = item;
        } else {                                            //идём из начала в конец
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.item = item;
        }
    }

    public int indexOf (Item item) {
        Node currentNode = first;
        int currentIndex = 0;
//        while (!currentNode.item.equals(item) && currentNode != null) {           //не работает (в случае если элемента нет в списке выкидывает nullpointexception) (!currentNode.item.equals(item) идёт обращение к null)
        while (currentIndex != size && !currentNode.item.equals(item)) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentNode != null) {
            return currentIndex;
        } else return -1;
//        return currentNode != null ? currentIndex : -1;                            //аррр! никак не запомню ):
    }

    public boolean contains (Item item){
        return (indexOf(item) != -1);
    }

    public Item remove (Item item) {
        Node currentNode = first;
        int currentIndex = 0;
//        while (!currentNode.item.equals(item) && currentNode != null){            //не работает (в случае если элемента нет в списке выкидывает nullpointexception) (!currentNode.item.equals(item) идёт обращение к null)
        while (currentIndex != size && !currentNode.item.equals(item)) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentNode == null) {
            return null;
        }else if (currentNode == first) {
            return (removeFirst());
        }else if (currentNode == last) {
            return (removeLast());
        }else {
            currentNode.next.previous = currentNode.previous;           //работает, но возможно не очень красиво выглядит, хотя вполне логично на мой взгляд
            currentNode.previous.next = currentNode.next;
            currentNode.previous = null;
            currentNode.next = null;
            size--;
            return currentNode.item;
        }
    }

    public void add (int index, Item item) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        if (index == 0){
            addFirst(item);
        } else if (index == size){
            addLast(item);
        } else if (index >= size/2){                                        //если индекс во второй половине списка
            Node currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index) {
                currentNode = currentNode.previous;
                currentIndex--;
            }
            Node newNode = new Node(currentNode.previous, item, currentNode);
            currentNode.previous.next = newNode;
            currentNode.previous = newNode;
            size++;
        } else {                                                            //если индекс в первой половине списка
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            Node newNode = new Node(currentNode.previous, item, currentNode);
            currentNode.previous.next = newNode;
            currentNode.previous = newNode;
            size++;
        }
    }

    public Item removeByIndex (int index) {                                 //удаление элемента по индексу
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        if (index == 0) {                                                   //проверка на первый элемент
            return (removeFirst());
        } else if (index == size - 1){                                      //проверка на последний элемент
            return (removeLast());
        } else if (index >= size/2){                                        //индекс во второй половине (идём с конца в начало)
            Node currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index){
                currentNode = currentNode.previous;
                currentIndex--;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            currentNode.next = null;
            currentNode.previous = null;
            size--;
            return currentNode.item;
        } else {                                                            //индекс в первой половине
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            currentNode.next = null;
            currentNode.previous = null;
            size--;
            return currentNode.item;
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null){
            s.append(currentNode.item.toString() + ", ");
            currentNode = currentNode.next;
        }
        return s.toString();
    }

}
