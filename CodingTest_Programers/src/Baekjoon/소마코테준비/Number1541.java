package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number1541 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();
        String[] splitMinus = question.split("-");
        int answer = 0;
        for(int i = 0; i < splitMinus.length; i++){
            int temp = sumSplitPlus(splitMinus[i]);
            if (i == 0) answer = answer + temp;
            else answer = answer - temp;
        }
        System.out.println(answer);
    }

    private static int sumSplitPlus(String splitMinus) {
        int sum = 0;
        String[] splitPlus = splitMinus.split("[+]");
        for(int i = 0; i < splitPlus.length; i++){
            sum += Integer.parseInt(splitPlus[i]);
        }
        return sum;
    }
}
