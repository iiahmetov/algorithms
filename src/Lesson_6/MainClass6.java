package Lesson_6;

import java.util.Random;

public class MainClass6 {
    public static void main(String[] args) {
//        MyTreeMap <Character, Integer> map = new MyTreeMap<>();
//        map.put('S', 1);
//        map.put('E', 1);
//        map.put('A', 1);
//        map.put('R', 1);
//        map.put('C', 1);
//        map.put('H', 1);
//        map.put('X', 1);
//        map.put('Z', 1);
//        map.remove('E');
//        System.out.println(map.isBalanced());

//        MyTreeMap <Character, Integer> map = new MyTreeMap<>();
//        map.put('E', 1);
//        map.put('D', 1);
//        map.put('C', 1);
//        map.put('B', 1);
//        map.put('A', 1);
//        map.put('F', 1);
//        map.put('G', 1);
//        map.put('H', 1);
//        map.put('I', 1);
//        System.out.println(map.isBalanced());

        int Size = 1000;                                                //количество создаваемых деревьев
        MyTreeMap <Integer, Integer> [] Treese = new MyTreeMap[Size];   //объявляем массив деревьев
        int balancedNum = 0;                                            //счётчик сбалансированных деревьев
        for (int i = 0; i < Size; i++) {
            Treese[i] = buildTree(6);                         //в цикле создаём случайное дерево
            System.out.println(Treese[i].isBalanced());                 //проверяем созданное дерео на сбалансированность
            if (Treese[i].isBalanced() == true) balancedNum++;          //если сбалансировано, то увеличиваем счётчик
        }
        System.out.println("Количество сбалансированных деревьев равно " + (balancedNum * 100.0 / Size) + " процентов от общего числа.");
    }

    public static MyTreeMap buildTree (int maxHeight){                  //метод создания случайного дерева
        Random rand = new Random();                                     //инициализируем рандомайзер
        MyTreeMap <Integer, Integer> tree = new MyTreeMap<>();          //инициализируем дерево
        boolean flag = true;                                            //создаём флаг, для прерывания добавления ключей в дерево, в случае превышения высоты
        int ansTUQoLtUaE = 42;                                          //полезная нагрузка в узлах дерева (Ответ на главный вопрос жизни, вселенной и всего такого)
        int tempKey;                                                    //буфер для фиксации текущего ключа
        while (flag) {                                                  //до тех пор пока флаг не ложный
            tempKey = rand.nextInt(201) - 100;                  //создаём случайный ключ в диапазоне от -100 до  100 и сохраняем его в буфер
            tree.put(tempKey, ansTUQoLtUaE);                            //вставляем сгенерированный ключ в дерево
            if (tree.height() > maxHeight) {                            //проверяем не превысило ли дерево максимальную высоту
                tree.remove(tempKey);                                   //если превысило, то удаляем ключ (забрав его значение из буфера)
                flag = false;                                           //флаг - ложь
            }
        }
        return tree;                                                    //отдаём полученное дерево
    }
}
