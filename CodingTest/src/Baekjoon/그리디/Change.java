package Baekjoon.그리디;

import java.io.IOException;
import java.util.Scanner;

public class Change {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int change = scanner.nextInt();

        int coinCount = 0;
        while(change != 0){
            change = change >= 500 ? change - 500 :
                    change >= 100 ? change - 100 :
                            change >= 50 ? change - 50 : change - 10;
            coinCount++;
        }
        System.out.println(coinCount);
    }
}
