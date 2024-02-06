package Baekjoon.소마코테준비;
import java.io.*;
import java.util.*;
public class Number14002 {

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int numberLength = Integer.parseInt(buffer.readLine());
        int[] number = new int[numberLength];

        StringTokenizer tokenizer = new StringTokenizer(buffer.readLine());
        for(int i = 0; i < numberLength; i++){
            number[i] = Integer.parseInt(tokenizer.nextToken());
        }

        ArrayList<Integer>[] forPrintNumber = new ArrayList[numberLength];
        for(int i = 0; i < numberLength; i++){
            forPrintNumber[i] = new ArrayList<>();
        }

        int[] dp = new int[numberLength];
        dp[0] = 1;
        forPrintNumber[0].add(number[0]);

        for(int current = 1; current < numberLength; current++){
            int useIndex = 0;
            for(int past = current - 1; past >= 0; past--){
                if(number[current] > number[past] && dp[current] < dp[past] + 1) {
                    dp[current] = dp[past] + 1;
                    useIndex = past;
                }
            }
            if(dp[current] == 0){
                dp[current] = 1;
                forPrintNumber[current].add(number[current]);
            } else{
                for(int i : forPrintNumber[useIndex]){
                    forPrintNumber[current].add(i);
                }
                forPrintNumber[current].add(number[current]);
            }
        }

        int maxValueIndex = 0;
        int maxValue = 0;
        for(int i = 0; i < numberLength; i++){

            if(dp[i] > maxValue){
                maxValue = dp[i];
                maxValueIndex = i;
            }
        }
        System.out.println(maxValue);
        for(int i : forPrintNumber[maxValueIndex]){
            System.out.print(i + " ");
        }
    }
}
