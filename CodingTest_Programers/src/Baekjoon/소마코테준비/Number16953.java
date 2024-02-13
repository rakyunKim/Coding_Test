package Baekjoon.소마코테준비;

import java.util.*;
public class Number16953 {
    static int min;
    static long endNumber;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long startNumber = scanner.nextLong();
        endNumber = scanner.nextLong();

        min = -1;
        int count = 1;
        dfs(startNumber, count);
        if(min == -1){
            System.out.println(-1);
        } else{
            System.out.println(min);
        }
    }

    private static void dfs(long start, int count){
        if(start == endNumber){
            if(min == -1 || min > count){
                min = count;
            }
            return;
        }
        if(start * 2 <= endNumber){
            dfs(start * 2, count + 1);
        }
        if(10 * start + 1 <= endNumber){
            dfs(10 * start + 1, count + 1);
        }

    }
}
