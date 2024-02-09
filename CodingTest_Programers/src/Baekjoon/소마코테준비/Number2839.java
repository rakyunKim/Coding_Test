package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number2839 {
    static Stack<Integer> answer;
    static int count;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int targetNumber = scanner.nextInt();

        answer = new Stack<>();
        count = 10000001;
        int five = targetNumber / 5;
        int three = 0;
        if(targetNumber % 5 != 0){
            three = (targetNumber % 5) / 3;
        }
        if(five * 5 + three * 3 != targetNumber){
            while(five > 0){
                five -= 1;
                three = (targetNumber - five * 5) / 3;
                if(five * 5 + three * 3 == targetNumber){
                    break;
                }
            }
            if(five * 5 + three * 3 == targetNumber){
                System.out.println(five + three);
            }else{
                System.out.println(-1);
            }
        } else{
            System.out.println(five + three);
        }
    }

}
