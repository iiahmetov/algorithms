package Lesson_2;

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

        MyArrayList<Integer> list = new MyArrayList<>();                              //создал экземпляр списка
        int repeat = 10;                                                    //количество повторений сортировки списка
        int size = 100000;                                                  //размер списка
        int range = 100000;                                                 //диапазон случайных чисел в списке (от 0 до 99999)
        double totalSelecTime = 0;                                          //счётчик общего времени сортировки выбором
        double totalInsertTime = 0;                                         //счётчик общего времени сортировки вставкой
        createStandartList(list, size, range);                              //обращение к методу создания Эталонного списка
        System.out.printf("№ эксперимента"+ "\t" + "Выбор" + "\t\t" + "Вставка");    //шапка таблицы
        System.out.println();                                                           //перенос каретки
        for (int i = 0; i < repeat; i++) {                                  //цикл сортировок
            System.out.printf((i+1) + "\t\t\t\t");                          //вывод номера сортировки
            totalSelecTime += selectionSortTime(list);                      //проведение сортировки выбором + увеличение общего времени сортировки выбором на время проведения операции (:
            totalInsertTime += insertionSortTime(list);                     //проведение сортировки вставкой + увеличение общего времени сортировки вставкой на время проведения операции (:
            System.out.println();                                           //перенос каретки
        }
        System.out.println("Среднее время сортировки выбором равно " + totalSelecTime/repeat + " секунд, при " + repeat + " повторениях сортировки.");   //вывод среднего времени сортировки выбором
        System.out.println("Среднее время сортировки вставкой равно " + totalInsertTime/repeat + " секунд, при " + repeat + " повторениях сортировки.");    //вывод среднего времени сортировки вставкой
    }

    public static MyArrayList createStandartList (MyArrayList list, int size, int range){     //метод создания эталонного списка
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.appendItem(random.nextInt(range));
        }
        return list;
    }

    public static MyArrayList copyList (MyArrayList list){                                    //метод создания временного списка - точной копии эталонного
        MyArrayList temp = new MyArrayList();
        for (int i = 0; i < list.getSize(); i++) {
            temp.appendItem(list.getItem(i));
        }
        return temp;
    }

    public static double selectionSortTime (MyArrayList list){                       //метод с сортировкой выбором и вычислением времени данной операции
        MyArrayList<Integer> list1 = new MyArrayList<>();                                   //объявляю временный список
        long tStart;                                                            //время старта сортировки
        long tFinish;                                                           //время финиша сортировки
        double opTime;                                                          //время операции
        list1 = copyList(list);                                                 //копирую данные эталонного списка во временный
        tStart = System.currentTimeMillis();                                    //фиксирую время старта сортировки
        list1.selectionSort(Integer::compareTo);                                //провожу сортировку выбором
        tFinish = System.currentTimeMillis();                                   //фиксирую время финиша сортировки
        opTime = (tFinish - tStart)/1000.0;                                     //вычисляю время операции сортировки
        System.out.printf(opTime + "sec" + "\t");                               //вывожу в консоль время
        return opTime;                                                          //возвращаю время операции сортировки
    }

    public static double insertionSortTime (MyArrayList list){                       //метод с сортировкой вставкой и вычислением времени данной операции
        MyArrayList<Integer> list1 = new MyArrayList<>();                                   //объявляю временный список
        long tStart;                                                            //время старта сортировки
        long tFinish;                                                           //время финиша сортировки
        double opTime;                                                          //время операции
        list1 = copyList(list);                                                 //копирую данные эталонного списка во временный
        tStart = System.currentTimeMillis();                                    //фиксирую время старта сортировки
        list1.insertionSort(Integer::compareTo);                                //провожу сортировку вставкой
        tFinish = System.currentTimeMillis();                                   //фиксирую время финиша сортировки
        opTime = (tFinish - tStart)/1000.0;                                     //вычисляю время операции сортировки
        System.out.printf(opTime + "sec" + "\t");                               //вывожу в консоль время
        return opTime;                                                          //возвращаю время операции сортировки
    }
}
