package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1920Retry {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int questionCount = scanner.nextInt();
        int[] question = new int[questionCount];

        for(int i = 0; i < questionCount; i++){
            question[i] = scanner.nextInt();
        }

        int targetCount = scanner.nextInt();
        int[] target = new int[targetCount];
        int[] answer = new int[targetCount];

        for(int i = 0;i < targetCount; i++){
            target[i] = scanner.nextInt();
        }

        Arrays.sort(question);



        for(int i = 0; i < targetCount; i++){
            int start = 0;
            int end = questionCount - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(target[i] == question[mid]){
                    answer[i] = 1;
                    break;
                } else if(target[i] < question[mid]){
                    end = mid - 1;
                } else if(target[i] > question[mid]){
                    start = mid + 1;
                }
            }
        }

        for(int i : answer){
            System.out.println(i);
        }
    }
}
