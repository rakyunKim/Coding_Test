package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number1436 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int num = 666;
        int count = 1;

        while(count != n) {
            num++;

            // int형인 num을 String으로 변환한 뒤, "666"이란 문자열이 있는지 검사
            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }
}
