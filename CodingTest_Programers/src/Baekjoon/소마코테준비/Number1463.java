package Baekjoon.소마코테준비;

import java.util.Scanner;

public class Number1463 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        long[] D = new long[target + 1];
        D[0] = 0;
        D[1] = 0;
        long answer = 0;
        for (int i = 2; i <= target; i++){
            answer = D[i - 1] + 1;
            if (i % 3 == 0 && answer > D[i / 3]){
                answer = D[i / 3] + 1;
            }
            if (i % 2 == 0 && answer > D[i / 2]){
                answer = D[i / 2] + 1;
            }
            D[i] = answer;
        }
        System.out.println(D[target]);
    }
}
