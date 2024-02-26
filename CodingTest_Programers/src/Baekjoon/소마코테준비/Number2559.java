package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/**
 * 온도를 입력 받고 온도 배열에 저장한다.
 * dfs() 함수를 만들어서 온도 배열을 재귀적으로 돌며
 * 각 구간마다 온도의 합의 최대를 찾는다.
 * 1부터 5까지 돌아서 depth가 5가 되었으면 1이 아닌 2로 넘어가서 돌아야 한다.
 * for문은 이 전의 인덱스 + 1 부터 돌아야 한다.
 */

public class Number2559 {
    static int targetCount;
    static int[] temperature;
    static int maxSum = Integer.MIN_VALUE;
    static int sum;
    static int temperatureLength;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        temperatureLength = scanner.nextInt();
        targetCount = scanner.nextInt();

        temperature = new int[temperatureLength];
        for(int i = 0; i < temperatureLength; i++){
            temperature[i] = scanner.nextInt();
        }

        for(int i = 0; i < targetCount; i++){
            sum += temperature[i];
        }
        if(maxSum < sum){
            maxSum = sum;
        }
//        System.out.println("MAXSUM :: " + maxSum);
//        System.out.println("SUM :: " + sum);

        for(int i = targetCount; i < temperatureLength; i++){
//            System.out.println("현재 i값 :: " + i);
//            System.out.println("현재 sum값 :: " + sum);
//            System.out.println("-------------------------------");

            sum = sum - temperature[i - targetCount] + temperature[i];
            if(maxSum < sum){
                maxSum = sum;
            }
//            dfs(i,0, 0);
        }
        System.out.println(maxSum);
    }

    private static void dfs(int startIndex, int depth, int sum) {
        if(depth == targetCount ){
            if(maxSum < sum){
                maxSum = sum;
            }
            return;
        } else {
//            System.out.println("시작 인덱스 :: " + startIndex);
//            System.out.println("현재 뎁스 :: " + depth);
//            System.out.println("현재 더한 값 :: " + sum);
//            System.out.println("sum에 더해질 값 :: " + temperature[startIndex]);
//            System.out.println("-------------------------------");
            dfs(startIndex + 1, depth + 1, sum += temperature[startIndex]);
        }
    }
}
