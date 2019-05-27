package Lesson_3;

import java.util.Scanner;

public class MainClass3 {
    public static void main(String[] args) {

//        MyArrayStack <Character> stack = new MyArrayStack<>();
//        stack.push('q');
//        stack.push('w');
//        stack.push('e');
//        stack.push('r');
//        System.out.println(stack);
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.toString());

//        MyArrayQueue <Character> queue = new MyArrayQueue<>();
//        queue.Enqueue('q');
//        queue.Enqueue('w');
//        queue.Enqueue('e');
//        queue.Enqueue('r');
//        System.out.println(queue);
//        System.out.println(queue.isEmpty());
//        System.out.println(queue.size());
//        System.out.println(queue.peekFront());
//        System.out.println(queue.Dequeue());
//        System.out.println(queue.peekFront());
//        System.out.println(queue.toString());

//        MyArrayDeque <Character> deque = new MyArrayDeque<>();
        My2StackDeque <Character> deque = new My2StackDeque<>();
        deque.pushTail('q');
        deque.pushTail('w');
        deque.pushTail('e');
        deque.pushTail('r');
        deque.pushTail('t');
        System.out.println(deque.popHead());
        System.out.println(deque);
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.peekHead());
        System.out.println(deque.popHead());
        System.out.println(deque.peekHead());
        System.out.println(deque.toString());
        deque.pushHead('y');
        System.out.println(deque);
        System.out.println(deque.peekTail());
        System.out.println(deque.popTail());
        System.out.println(deque.peekTail());
        System.out.println(deque.toString());

//        revert();
    }

    public static void revert () {                              //метод переворачивания строки
        Scanner sc = new Scanner(System.in);                    //организуем сканнер из консоли
        StringBuilder sb = new StringBuilder();                 //объявляем стрингбилдер
        MyArrayStack<String> stack = new MyArrayStack<>();      //объявляем стэк строк
        System.out.println("Введите строку");                   //просим ввести исходную строку
        String string = sc.nextLine();                          //сканируем введённую строку
        String[] s = string.split("");                   //разбиваем строку на строчный массив из отдельных строк/символов
        for (int i = 0; i < string.length(); i++) {             //в цикле наполняем стек символами из массива
            stack.push(s[i]);
        }
        do {
            sb.append(stack.pop());                             //в цикле опустошаем стэк
        } while(!stack.isEmpty());                              //прерывает цикл когда стэк пуст
        System.out.println("Перевёрнутая строка:");
        System.out.println(sb.toString());                      //выводим на экран перевёрнутую строку
        sc.close();                                             //закрываем сканнер
    }
}
