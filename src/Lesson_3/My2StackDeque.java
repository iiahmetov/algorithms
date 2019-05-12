package Lesson_3;

import java.util.NoSuchElementException;

public class My2StackDeque <Item>{
    private MyArrayStack<Item> HeadStack = new MyArrayStack<>();
    private MyArrayStack<Item> TailStack = new MyArrayStack<>();

    public boolean isEmpty (){
        return (TailStack.isEmpty() && HeadStack.isEmpty());
    }

    public int size(){
        return (HeadStack.size() + TailStack.size());
    }

    public void pushTail (Item item){
        TailStack.push(item);
    }

    public void pushHead (Item item){
        HeadStack.push(item);
    }

    private void transfer(MyArrayStack from, MyArrayStack to){ //метод переноса данных в случае если обращаются к пустому (реципиентному) стэку
        Object[] temp = new Object[from.size()];               //объявляю временный массив для сохранения данных из не пустого (донорного) стека
        int n = 0;
        while (!from.isEmpty()){                                //выщёлкиваю все данные из донорного стека в массив
            temp[n] = from.pop();
            n++;
        }
        for (int i = temp.length/2; i < temp.length ; i++) {    //беру правую половину данных и перекидываю её в реципиентный стэк
            to.push(temp[i]);
        }
        for (int i = temp.length/2 - 1; i >= 0 ; i--) {         //левую половину массива закидываю в обратно в донорный стэк (из середины в начало чтобы соблюсти правильный порядок данных)
            from.push(temp[i]);
        }
    }

    public Item popTail(){
        if (isEmpty()){                                                 //если дек пуста, то выдаю сообщение
            throw new NoSuchElementException("Deque is empty");
        }
        if (TailStack.isEmpty() == true && HeadStack.size() == 1){      //если опрашиваемый стек пуст, а во втором всего 1 элемент, то обращаюсь ко второму стэку
            return HeadStack.pop();
        }
        if (TailStack.isEmpty() == true && HeadStack.size() > 1){       //если опрашиваемый стек пуст, а во втором больше чем 1 элемент, то переливаю половину элементов из второго стэка в первый
            transfer(HeadStack, TailStack);
        }
        return TailStack.pop();                                         //если в опрашиваемом стеке есть элемент, то отдаю его
    }

    public Item popHead(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        if (HeadStack.isEmpty() == true && TailStack.size() == 1){
            return TailStack.pop();
        }
        if (HeadStack.isEmpty() == true && TailStack.size() > 1){
            transfer(TailStack, HeadStack);
        }
        return HeadStack.pop();
    }

    public Item peekTail(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        if (TailStack.isEmpty() == true && HeadStack.size() == 1){
            return HeadStack.peek();
        }
        if (TailStack.isEmpty() == true && HeadStack.size() > 1){
            transfer(HeadStack, TailStack);
        }
        return TailStack.peek();
    }

    public Item peekHead(){
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        if (HeadStack.isEmpty() == true && TailStack.size() == 1){
            return TailStack.peek();
        }
        if (HeadStack.isEmpty() == true && TailStack.size() > 1){
            transfer(TailStack, HeadStack);
        }
        return HeadStack.peek();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();                  //объявляю стрингбилдер
        Object[] temp = new Object[HeadStack.size()];           //объявляю временный массив
        for (int i = 0; i < temp.length; i++) {                 //для стэка головы дека поэлементно перекидываю данные в массив
            temp[i] = HeadStack.pop();
            s.append(temp[i] + ", ");                           //добавляю элемент к стрингбилдеру
        }
        for (int i = temp.length - 1; i >= 0 ; i--) {           //возвращаю элементы в стэк головы в нужной последовательности
            HeadStack.push((Item)temp[i]);
        }
        s.append(TailStack.toString());                         //добавляю в стрингбилдер данные из хвостового стека
        return s.toString();                                    //возвращаю стрингбилдер
    }
}
