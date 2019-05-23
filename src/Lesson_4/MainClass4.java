package Lesson_4;

public class MainClass4 {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addFirst('a');
        list.addFirst('b');
        list.addFirst('c');
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(1));
        list.set(1, 'd');
        System.out.println(list.get(1));
        list.addFirst('e');
        list.addLast('f');
        list.add(2, 'g');
        list.addFirst('h');
        System.out.println(list);
        list.removeLast();
        list.removeFirst();
        System.out.println(list.indexOf('x'));              //метод поиска индекса несуществующего элемента в том исполнении, что был на семинаре выдаёт nullpointexception
        System.out.println(list.contains('x'));             //аналогичноб т.к. ссылается на indexOf
        System.out.println(list.indexOf('a'));
        System.out.println(list.contains('a'));
        System.out.println(list.remove('x'));           //метод удаления несуществующего элемента в том исполнении, что был на семинаре выдаёт nullpointexception
        list.remove('c');
        System.out.println(list);
        System.out.println(list.removeByIndex(2));
        System.out.println(list.size());
//        System.out.println(list);

        for (Character item:
             list) {
            System.out.print(item + ", ");
        }
    }
}
