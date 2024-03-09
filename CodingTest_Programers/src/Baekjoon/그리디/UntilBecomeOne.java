package Baekjoon.그리디;

import java.io.IOException;
import java.util.Scanner;

public class UntilBecomeOne {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int count = 0;
        while(N != 1){
            N = N % K == 0 ? N / K : N - 1;
            count++;
        }
        System.out.println(count);
    }
}
