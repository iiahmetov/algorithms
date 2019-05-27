package Lesson_2;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList <Item> implements Iterable <Item>{
    private int size = 0;
    private Object[] list = new Object [1];


    public Item getItem (int index) {
        if (index < 0 || index > size -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void setItem (int index, Item item){
        if (index < 0 || index > size -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list[index] = item;
    }

    public int getSize (){
        return size;
    }

    private void resizeList (int newcapacity){
        Object [] temp = new Object[newcapacity];
        for (int i = 0; i < list.length ; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }

    public void appendItem (Item Item){
        if (size == list.length) {
            resizeList(list.length*2);
        }
        list[size] = Item;
        size++;
    }

    public boolean remove (Item item){
        int index = indexOf(item);
        if (index == -1){
            return false;
        }
        for (int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[size-1] = null;
        size--;
        if (size > 0 && size == list.length/4) {
            resizeList(list.length/2);
        }
        return true;
    }

    public int indexOf (Item item){
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return (-1);
    }

    public boolean containsOf (Item item){
        return (indexOf(item)!= -1);
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class MyListIterator implements Iterator <Item>{

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) list[cursor];
            cursor++;
            return item;
        }
    }

    public String toString (){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
        s.append(list[i] + ", ");
        }
        return s.toString();
    }

    private void exchange (int i, int j){
        Object temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private boolean less (Item item1, Item item2, Comparator<Item> cmp){
        return cmp.compare(item1, item2) < 0;
    }

    public void selectionSort (Comparator<Item> cmp){
        for (int i = 0; i < size-1 ; i++) {
            int min = i;
            for (int j = i; j < size; j++) {
                if (less((Item) list[j], (Item) list[min], cmp)){
                    min = j;
                }
            }
            exchange(i, min);
        }
    }

    public void insertionSort (Comparator<Item> cmp){
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item)list[j], (Item) list[j-1], cmp)){
                    exchange(j, j-1);
                } else break;
            }
        }
    }

    public boolean binarySearch (Item item, Comparator<Item> cmp){
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (cmp.compare(item, (Item) list[mid]) < 0) {
                high = mid - 1;
            } else if (cmp.compare(item, (Item) list[mid]) > 0){
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
