package Baekjoon.소마코테준비;
import java.util.*;
public class Number1717Retry {
    static int[] parent;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberRange = scanner.nextInt();
        parent = new int[numberRange + 1];
        for(int i = 1; i <= numberRange; i++){
            parent[i] = i;
        }
        int operationCount = scanner.nextInt();

        for(int i = 0; i < operationCount; i++){
            int operation = scanner.nextInt();
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();
            if(operation == 0){
                union(firstNumber, secondNumber);
            }else{
                int firstParent = find(firstNumber);
                int secondParent = find(secondNumber);
                if(firstParent == secondParent) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static void union(int first, int second){
        int firstParent = find(first);
        int secondParent = find(second);

        if(firstParent <= secondParent){
            parent[secondParent] = parent[firstParent];
        } else{
            parent[firstParent] = parent[secondParent];
        }
    }

    private static int find(int num){
        if(num == parent[num]) return num;
        else{
            return parent[num] = find(parent[num]);
        }
    }
}