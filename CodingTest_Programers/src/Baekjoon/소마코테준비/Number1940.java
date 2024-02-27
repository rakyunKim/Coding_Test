package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1940 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int ingredientCount = scanner.nextInt();
        int targetNumber = scanner.nextInt();
        int[] ingredient = new int[ingredientCount];

        for(int i = 0; i < ingredientCount; i++){
            ingredient[i] = scanner.nextInt();
        }

        int count = 0;
        for(int i = 0; i < ingredientCount; i++){
            for(int j = i + 1; j < ingredientCount; j++){
                if(ingredient[i] + ingredient[j] == targetNumber) count++;
            }
        }

        System.out.println(count);

    }
}