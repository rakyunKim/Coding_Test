package Baekjoon.소마코테준비;

import javax.naming.spi.DirObjectFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Number1920 {
    static int[] question;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int questionLength = Integer.parseInt(bufferedReader.readLine());
        question = new int[questionLength];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < questionLength; i++){
            question[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(question);

        int targetLength = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < targetLength; i++){
            if (binarySearch(Integer.parseInt(stringTokenizer.nextToken()))){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static boolean binarySearch(int element) {
        boolean answer = false;
        int start = 0;
        int end = question.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (element == question[mid]) {
                answer = true;
                break;
            }
            else if (element > question[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
