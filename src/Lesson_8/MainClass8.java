package Lesson_8;

public class MainClass8 {
    public static void main(String[] args) {
        MyChainingHashMap <Character, Integer> map = new MyChainingHashMap<>();
        map.put('a', 1);
        map.put('g', 1);
        map.put('w', 1);
        map.put('h', 1);
        map.put('p', 1);
        map.put('m', 1);
        map.put('t', 1);
        map.put('q', 1);
        map.put('e', 1);
//        System.out.println(getPrime(97));
//        System.out.println(isPrime(97));
    }

//    public static boolean isPrime (int n){
//        for (int i = 2; (i * i) <= n ; i++) {
//            if ((n % i) == 0) return false;
//        }
//        return true;
//    }
//
//    public static int getPrime (int current){
//        int nextPrime;
//        for (int i = 1; true ; i++) {
//            nextPrime = current + i;
//            if (isPrime(nextPrime) == true) {
//                return nextPrime;
//            }
//        }
//    }
}
