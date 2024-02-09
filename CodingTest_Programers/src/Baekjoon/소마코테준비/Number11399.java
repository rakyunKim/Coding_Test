package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number11399 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int personCount = scanner.nextInt();
        int[] count = new int[personCount];
        for(int i = 0; i < personCount; i++){
            count[i] = scanner.nextInt();
        }
        Arrays.sort(count);

        int answer = 0;
        for(int i = 0; i < personCount; i++){
            int time = count[i];
            for(int j = i - 1; j >= 0; j--){
                time += count[j];
            }
            answer += time;
        }
        System.out.println(answer);
    }
}
