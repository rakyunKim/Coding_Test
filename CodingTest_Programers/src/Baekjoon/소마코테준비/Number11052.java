package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number11052 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cardCount = scanner.nextInt();
        int[] cardValue = new int[cardCount + 1];
        int[] maxCardValueArr = new int[cardCount + 1];

        for (int i = 1; i <= cardCount; i++){
            cardValue[i] = scanner.nextInt();
        }

        for (int i = 1; i <= cardCount; i++){
            for (int j = 1; j <= i; j++){
                maxCardValueArr[i] = Math.max(maxCardValueArr[i], maxCardValueArr[i - j] + cardValue[j]);
            }
        }
        System.out.println(maxCardValueArr[cardCount]);
    }
}
