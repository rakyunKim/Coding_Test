package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Number15649Retry {
    // 방문배열 자료구조 방문배열은 숫자의 범위까지 돌아서 stringBuild에 값을 저장하고 나면 초기화 해줘야 한다.
    static List<Integer> visited;
    static int numberRange;
    static int numberCount;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        numberRange = scanner.nextInt();
        numberCount = scanner.nextInt();
        visited = new ArrayList<>();

        for (int i = 1; i <= numberRange; i++){
            recursive(i, 0);
        }
    }

    private static void recursive(int currentNumber, int depth) {
        if (depth == numberCount - 1){
            visited.add(currentNumber);

            visited.forEach(it -> {
                System.out.print(it + " ");
            });
            System.out.println();
        }

        else if (!visited.contains(currentNumber)){
            visited.add(currentNumber);
            for (int i = 1; i <= numberRange; i++){
                if (!visited.contains(i)){
                    recursive(i, depth + 1);
                }
            }
        }
        visited.remove(depth);
    }
}
