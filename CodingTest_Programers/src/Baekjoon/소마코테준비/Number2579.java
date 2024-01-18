package Baekjoon.소마코테준비;

import java.util.Scanner;

public class Number2579 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int stairCount = scanner.nextInt();

        int[] arr = new int[stairCount + 1];
        int[] previous = new int[stairCount + 1];
        int[] prePrevious = new int[stairCount + 1];
        for (int i = 1; i <= stairCount; i++){
            arr[i] = scanner.nextInt();
        }

        previous[1] = arr[1];
        prePrevious[1] = 0;
        if (stairCount >= 2){
            previous[2] = previous[1] + arr[2];
            prePrevious[2] = prePrevious[1] + arr[2];

            for (int i = 3; i <= stairCount; i++){
                previous[i] = arr[i] + prePrevious[i - 1];
                prePrevious[i] = Math.max(previous[i - 2] + arr[i], prePrevious[i - 2] + arr[i]);
            }
            System.out.println(Math.max(previous[stairCount], prePrevious[stairCount]));
        } else {
            System.out.println(Math.max(previous[stairCount], prePrevious[stairCount]));

        }
    }
}
