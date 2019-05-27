package Lesson_6;

import java.util.NoSuchElementException;

public class MyTreeMap <Key extends Comparable <Key>, Value> {

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;                                                     //высота дерева
        public Node (Key key, Value value, int size, int height){
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    private Node root = null;

    private boolean Balance = true;                                  //флаг, характеризующий сбалансированность дерева

    public boolean isEmpty(){
        return (root == null);
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node == null) {
            return 0;
        } else return node.size;
    }

    private void sizeCount(Node node){                              //метод, вычисляющий размер дерева
        node.size = size(node.left) + size(node.right) + 1;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){                                  //вспомогательный метод для получения высоты дерева
        if (node == null) {
            return -1;
        } else return node.height;
    }

    private void heightCount(Node node){                            //метод, вычисляющий высоту дерева
        if (height(node.left) >= height(node.right)){
            node.height = height(node.left) + 1;
        } else {
            node.height = height(node.right) + 1;
        }
    }

    public boolean isBalanced(){                                    //метод определяющий сбалансировано ли дерево
        Balance = true;                                             //величина Баланс по-умолчанию true
        isBalanced(root);                                           //обращение к скрытому вспомогательному методу
        return (Balance);                                           //вывод сбалансировано ли дерево
    }

    private void isBalanced(Node node){                             //вспомогательный метод
        if (node == null) {                                         //базовый вариант (дерево пустое  -  Баланс не меняется)

        }else if (node.right == null && node.left == null) {        //базовый вариант (лист дерева - Баланс не меняется)

        } else if (node.left == null){                              //рекурсивный вариант "нет левого поддерева"
            if (node.right.height > 1) {Balance = false;}           //проверка высоты правого поддерева (если больше 1 то Баланс изменяется)
            isBalanced(node.right);                                 //уходим вправо
        } else if (node.right == null){                             //рекурсивный вариант "нет правого поддерева"
            if (node.left.height > 1) {Balance = false;}            //проверка высоты левого поддерева (если больше 1 то Баланс изменяется)
            isBalanced(node.left);                                  //уходим влево
        } else {                                                    //рекурсивный вариант "есть оба поддерева"
            isBalanced(node.left);                                  //поочерёдно уходим влево
            isBalanced(node.right);                                 //уходим вправо
            if (Math.abs(node.left.height - node.right.height) > 1) {Balance = false;}  //сравниваем разницу между высотами правого и левого поддерева по модулю с 1 (если больше, то изменяем Баланс)
        }
    }

    public Value get (Key key){
        return get(key, root);
    }

    private Value get (Key key, Node node) {
        if (key == null) {
            throw new NoSuchElementException("Null key is imposibru -_-");
        }
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) == 0){
            return node.value;
        } else if (key.compareTo(node.key) < 0){
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }

    public void put (Key key, Value value){
        root = put(key, value, root);
    }

    private Node put (Key key, Value value, Node node){
        if (key == null) {
            throw new NoSuchElementException("Null key is imposibru -_-");
        }
        if (node == null) {
            return new Node(key, value, 1, 0);
        }
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = put(key, value, node.left);
        } else {
            node.right = put(key, value, node.right);
        }
        sizeCount(node);
        heightCount(node);
        return node;
    }

    private Node leftmost (Node node){
        if (node.left == null) {
            return node;
        } else return leftmost(node.left);
    }

    public Value minKeyValue(){
        return leftmost(root).value;
    }

    private Node rightmost (Node node){
        if (node.right == null) {
            return node;
        } else return rightmost(node.right);
    }

    public Value maxKeyValue(){
        return rightmost(root).value;
    }

    private Node removeLeftmost (Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = removeLeftmost(node.left);
        }
        sizeCount(node);
        heightCount(node);
        return node;
    }

    public void removeLeftmost() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeLeftmost(root);
    }

    private Node removeRightmost (Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = removeRightmost(node.right);
        }
        sizeCount(node);
        heightCount(node);
        return node;
    }

    public void removeRightmost (){
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }
        root = removeRightmost(root);
    }

    public void remove (Key key){
        root = remove(key, root);
    }

    private Node remove (Key key, Node node){
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node tmp = node;
            node = leftmost(node.right);                //замена удаляемого узла на самый левый (маленький) в правой ветви
            node.right = removeLeftmost(tmp.right);
            node.left = tmp.left;
//            node = rightmost(node.left);              //замена удаляемого узла на самый правый (большой) в левой ветви
//            node.left = removeRightmost(tmp.left);
//            node.right = tmp.right;
            tmp = null;

        } else if (key.compareTo(node.key) < 0){
            node.left = remove(key, node.left);
        } else {
            node.right = remove(key, node.right);
        }
        sizeCount(node);
        heightCount(node);
        return node;
    }

}
