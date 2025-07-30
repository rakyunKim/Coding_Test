package Baekjoon.동적계획법;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class Number12865 {
    static ProductInfo[] products;
    static int[][] dp;
    static int productCount;
    static int bagSize;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        productCount = scanner.nextInt();
        bagSize = scanner.nextInt();


        products = new ProductInfo[productCount + 1];
        for (int i = 1; i <= productCount; i++) {
            products[i] = new ProductInfo(scanner.nextInt(), scanner.nextInt());
        }
        dp = new int[productCount + 1][bagSize + 1];

        for (int i = 1; i <= productCount; i++) {
            for (int j = bagSize; j >= 0; j--) {
                int exceptMeValue = dp[i - 1][j];
                if (j - products[i].weight < 0)
                    dp[i][j] = exceptMeValue;
                else
                {
                    int joinMeValue = products[i].value + dp[i - 1][(j - products[i].weight)];
                    dp[i][j] = Math.max(exceptMeValue, joinMeValue);
                }
            }
        }

        System.out.println(dp[productCount][bagSize]);
    }
}

class ProductInfo{
    int weight;
    int value;

    public ProductInfo(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
