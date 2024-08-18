package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number15649ReReRetry {
    static int numberRange;
    static int numberCount;
    static int[] visited;

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        numberRange = scanner.nextInt();
        numberCount = scanner.nextInt();
        visited = new int[numberRange + 1];
        find(1, 0);

    }

    private static void find(int start, int depth){
        if(depth == numberCount){
            for(int a : stack){
                System.out.print(a + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= numberRange; i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    stack.add(i);
                    find(start + 1, depth + 1);
                    stack.pop();
                    visited[i] = 0;
                }
            }
        }

    }
}
