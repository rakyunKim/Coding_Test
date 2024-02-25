package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/*
    start = 0
    end = size() - 1
    start와 end를 비교하며 두 개의 값이 같다면 continue
    아니면 break 후에 0 출력
    반복문은 두 개의 포인터가 만나거나 교차하기 전까지 실행
    반복문이 무사히 끝나면 1출력
 */

public class Number10988 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();

        char[] targetChar = target.toCharArray();

        int start = 0;
        int end = targetChar.length - 1;

        boolean isPossible = true;
        while(start <= end){
            if(targetChar[start] != targetChar[end]){
                isPossible = false;
                break;
            } else {
                start++;
                end--;
            }
        }

        System.out.println(isPossible ? 1 : 0);
    }
}
