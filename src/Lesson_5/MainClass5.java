package Lesson_5;

public class MainClass5 {
    public static void main(String[] args) {
        System.out.println(expon(2,37));
        System.out.println(exponRec(2,37));
        System.out.println(exponRecFast(2,37));
    }

    public static long exponRec(long number, int expon){
        if (number == 0){
            return 0;
        } else if (number == 1){
            return 1;
        } else if (expon == 0) {
            return 1;
        } else if (expon == 1) {
            return number;
        } else {
            return exponRec(number, expon - 1) * number;
        }

    }

    public static long expon (int number, int expon){
        long ans = 1;
        for (int i = 0; i < expon; i++) {
            ans *= number;
        }
        return ans;
    }

    public static long exponRecFast (long number, int expon){
        if (number == 0){
            return 0;
        } else if (number == 1) {
            return 1;
        } else if (expon == 0) {
            return 1;
        } else if (expon == 1) {
            return number;
        } else if (expon % 2 == 0) {
            long temp = exponRecFast(number, expon / 2);
            return temp * temp;
        } else {
            long temp = exponRecFast(number, expon / 2);
            return temp * temp * number;
        }
    }
}
