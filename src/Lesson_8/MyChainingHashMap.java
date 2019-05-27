package Lesson_8;

public class MyChainingHashMap <Key, Value> {
    private int M = 1;                              // начальное значение размера хэш-таблицы (простое число)
    private int size = 0;                           // количество элементов в таблице
    private Object[] st = new Object[M];            // массив списков
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash (Key key, int M){                  //метод хэширования, т.к. размер таблицы меняется, то помимо ключа вводится ещё и размер хэш-таблицы
        return ((key.hashCode() & 0x7FFFFFFF) % M);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void resizeNrehash (int newcapacity){       //метод изменения размера хэш-таблицы и перехэширования
        Object[] temp = new Object[newcapacity];        //создаём временный массив нового размера
        int oldcapacity = st.length;
        for (int i = 0; i < oldcapacity ; i++) {        //проходим циклом по старому массиву
            if (st[i] != null) {                        //если элемент (связный список) массива не null, то проходим по всему связному списку в данной ячейки массива
                Node currentNode = (Node) st[i];        //берём первый элемент связного списка
                while (currentNode != null) {           //пока не доёдём до конца связного списка, выполняем следующие операции
                    int h = hash(currentNode.key, newcapacity);     //получаем хэш ключа текущего элемента связного списка с учётом нового размера хэш-таблицы
                    if (temp[h] == null){                           //если данный элемент новой хэш таблицы пуст, то вставляем новый узел
                        temp[h] = new Node(currentNode.key, currentNode.value, null);
                    } else {                                        //иначе вставляем новый узел в начало и делаем ссылку на старый первый узел
                        temp[h] = new Node(currentNode.key, currentNode.value, (Node) temp[h]);
                    }
                    currentNode = currentNode.next;         //переходим к следующему элементу связного списка
                }
            }
        }
        st = temp;                      // перекидываем ссылки
    }

    private int getPrime (int current){             //метод получения следующего простого числа
        int nextPrime;
        for (int i = 1; true ; i++) {               //в цикле увеличиваем текущее простое число на 1 до тех пор, пока не получим простое число
            nextPrime = current + i;
            if (isPrime(nextPrime) == true) {
                return nextPrime;                   //возвращаем следующее простое число
            }
        }
    }

    private boolean isPrime (int n){                //метод проверки является ли число простым
        for (int i = 2; (i * i) <= n ; i++) {       //в цикле делим число и проверяем остаток от деления
            if ((n % i) == 0) return false;
        }
        return true;
    }

    public Value get(Key key){
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null");
        }
        int m = st.length;
        int h = hash(key, m);
        Node currentNode = (Node) st[h];
        while (currentNode != null) {
            if (key.equals(currentNode.key)){
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains(Key key){
        return (get(key) != null);
    }

    public void put(Key key, Value value){
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null");
        }
        int m = st.length;
        int h = hash(key, m);
        Node currentNode = (Node) st[h];
        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        st[h] = new Node (key, value, (Node) st[h]);
        size++;
        if (size > m) {                                 //если количество узлов связных списков больше, чем размер хэш-таблицы
            resizeNrehash(getPrime(m));                 //увеличиваем хэш-таблицу до следующего простого числа и перехэшируем
        }
    }
}
