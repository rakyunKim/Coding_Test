package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number1182 {
    static int numberCount;
    static int target;
    static int count;
    static int[] number;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        numberCount = scanner.nextInt();
        target = scanner.nextInt();

        number = new int[numberCount];
        for(int i = 0; i < numberCount; i++){
            number[i] =  scanner.nextInt();
        }

        backTracking(0,0);

        System.out.println(target == 0 ? count -1 : count);
    }

    private static void backTracking(int idx, int sum){
        if(idx == numberCount){
            if(sum == target) {
                count += 1;
            }
            return;
        }

        backTracking(idx + 1, sum + number[idx]);
        backTracking(idx + 1, sum);
    }
}
