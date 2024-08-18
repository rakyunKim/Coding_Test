package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number10773 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int operationCount = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < operationCount; i++){
            int operation = scanner.nextInt();
            if(operation == 0){
                stack.pop();
            } else {
                stack.push(operation);
            }
        }

        int sum = 0;
        for(int i : stack){
            sum += i;
        }

        System.out.println(sum);
    }
}
