package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1789 {
    static long numberSum;
    static long answer;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        numberSum = scanner.nextLong();
        answer = 0;
        findMax(1);
        System.out.println(answer);
    }

    private static void findMax(int value) {
        if(numberSum - value < 0) return;
        else{
            numberSum -= value;
            answer++;
            findMax(value + 1);
        }
    }
}
