package Baekjoon.소마코테준비;
import java.util.*;
public class Number2720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i++){
            int quarter = 0;
            int dime = 0;
            int nickel = 0;
            int penni = 0;
            int target = scanner.nextInt();

            while(target >= 25){
                target -= 25;
                quarter ++;
            }

            while(target >= 10){
                target -= 10;
                dime ++;
            }

            while(target >= 5){
                target -= 5;
                nickel ++;
            }

            while(target >= 1){
                target -= 1;
                penni ++;
            }
            System.out.println(quarter + " " + dime + " " + nickel + " " + penni);
        }
    }
}
