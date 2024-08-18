package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number5585 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int target = 1000 - scanner.nextInt();
        int count = 0;

        while(target > 0){
            if(target - 500 >= 0){
                target -= 500;
            } else if(target - 100 >= 0){
                target -= 100;
            } else if(target - 50 >= 0){
                target -= 50;
            } else if(target - 10 >= 0){
                target -= 10;
            } else if(target - 5 >= 0){
                target -= 5;
            } else {
                target -= 1;
            }
            count ++;
        }
        System.out.println(count);

    }
}
