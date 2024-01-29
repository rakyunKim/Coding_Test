package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Number15652 {
    static List<Integer> visited;
    static int numberRange;
    static int numberCount;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        numberRange = scanner.nextInt();
        numberCount = scanner.nextInt();
        visited = new ArrayList<>();

        // 넓이
        for (int i = 1; i <= numberRange; i++){
            // 깊이
            recursive(i, 0);
            visited.remove(0);
        }
    }

    private static void recursive(int currentNumber, int depth) {
        if (depth == numberCount - 1){
            visited.add(currentNumber);
            visited.forEach(it -> {
                System.out.print(it + " ");});
            System.out.println();
        } else {
            visited.add(currentNumber);
            for (int i = currentNumber; i <= numberRange; i++){
                recursive(i, depth + 1);
                visited.remove(depth + 1);
            }
        }
    }
}
