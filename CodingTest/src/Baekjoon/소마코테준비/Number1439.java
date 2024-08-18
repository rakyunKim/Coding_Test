package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1439 {
    static int[] qs;
    static int qsLength;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String question = scanner.next();
        char[] temp = question.toCharArray();
        qs = new int[temp.length];
        qsLength = qs.length;
        for(int i = 0; i < temp.length; i++){
            qs[i] = Integer.parseInt(String.valueOf(temp[i]));
        }

        int one = startOne();
        int zero = startZero();
        System.out.println(Math.min(one,zero));
    }

    private static int startOne(){
        int count = 0;
        boolean isContinue = false;
        for(int i = 0; i < qsLength; i++){
            if(qs[i] == 1 && !isContinue){
                count++;
                isContinue = true;
            }
            if(qs[i] == 0) isContinue = false;
        }
        return count;
    }
    private static int startZero(){
        int count = 0;
        boolean isContinue = false;
        for(int i = 0; i < qsLength; i++){
            if(qs[i] == 0 && !isContinue){
                count++;
                isContinue = true;
            }
            if(qs[i] == 1) isContinue = false;
        }
        return count;
    }
}
