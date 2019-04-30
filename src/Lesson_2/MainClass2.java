package Lesson_2;

import sun.awt.datatransfer.DataTransferer;

import java.util.Comparator;
import java.util.Random;

public class MainClass2 {
    public static void main(String[] args) {

//        MyList<Character> list = new MyList<>();
//        list.appendItem('z');
//        list.appendItem('d');
//        list.appendItem('x');
//        list.appendItem('r');
//        list.appendItem('f');
//        System.out.println(list);
//        System.out.println(list.getSize());
//        System.out.println(list.indexOf('c'));
//        System.out.println(list.indexOf('f'));
//        System.out.println(list.containsOf('x'));
//        System.out.println(list.remove('b'));
//        System.out.println(list.remove('x'));
//        System.out.println(list);
//        list.appendItem('g');
//        list.appendItem('t');
//        System.out.println(list);
//        list.selectionSort(new CharacterComparator());
//        list.insertionSort(Character::compareTo);
//        System.out.println(list);

        MyList<Integer> list = new MyList<>();
        int repeat = 5;
        int size = 100000;
        int range = 100000;
        double averageSortTime = 0;
        double averageInsertTime = 0;
        createStandartList(list, size, range);
        for (int i = 0; i < repeat; i++) {
            averageSortTime += selectionSortTime(list);
            averageInsertTime += insertionSortTime(list);
            System.out.println();
        }
        System.out.println("Среднее время сортировки выбором равно " + averageSortTime/repeat + " секунд, при " + repeat + " повторениях сортировки.");
        System.out.println("Среднее время сортировки вставкой равно " + averageInsertTime/repeat + " секунд, при " + repeat + " повторениях сортировки.");
    }

    public static MyList createStandartList (MyList list, int size, int range){
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.appendItem(random.nextInt(range));
        }
        return list;
    }

    public static MyList copyList (MyList list){
        MyList temp = new MyList();
        for (int i = 0; i < list.getSize(); i++) {
            temp.appendItem(list.getItem(i));
        }
        return temp;
    }

    public static double selectionSortTime (MyList list){
        MyList<Integer> list1 = new MyList();
        long tStart;
        long tFinish;
        double opTime;
        list1 = copyList(list);
        tStart = System.currentTimeMillis();
        list1.selectionSort(Integer::compareTo);
        tFinish = System.currentTimeMillis();
        opTime = (tFinish - tStart)/1000.0;
        System.out.printf(opTime + "sec ");
        return opTime;
    }

    public static double insertionSortTime (MyList list){
        MyList<Integer> list1 = new MyList();
        long tStart;
        long tFinish;
        double opTime;
        list1 = copyList(list);
        tStart = System.currentTimeMillis();
        list1.insertionSort(Integer::compareTo);
        tFinish = System.currentTimeMillis();
        opTime = (tFinish - tStart)/1000.0;
        System.out.printf(opTime + "sec ");
        return opTime;
    }
}
