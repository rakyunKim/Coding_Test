package Baekjoon.소마코테준비;
import java.util.*;
import java.io.*;

public class Number1717 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(buffer.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int operationCount = Integer.parseInt(st.nextToken());

        parent = new int[numberCount + 1];
        for(int i = 1; i <= numberCount; i++){
            parent[i] = i;
        }

        for(int i = 0; i < operationCount; i++){
            st = new StringTokenizer(buffer.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(operation == 0){
                union(first, second);
            } else{
               int firstParent = find(first);
               int secondParent = find(second);
                if (firstParent == secondParent){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int number) {
        if(parent[number] == number) return number;
        else{
            return parent[number] = find(parent[number]);
        }
    }

    private static void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);
        if(firstParent < secondParent){
            parent[secondParent] = firstParent;
        } else{
            parent[firstParent] = secondParent;
        }
    }
}
