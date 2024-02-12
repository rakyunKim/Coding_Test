package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number14888 {
    static int[] number;
    static int[] operator;
    static int numberCount;
    static long sum;
    static long maxValue = 0;
    static long minValue = 1000000001;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        numberCount = scanner.nextInt();
        number = new int[numberCount];
        for(int i = 0; i < numberCount; i++){
            number[i] = scanner.nextInt();
        }
        operator = new int[4];

        for(int i = 0; i < 4; i++){
            operator[i] = (scanner.nextInt());
        }

        dfs(number[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void dfs(int num, int idx) {
        if (idx == numberCount) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {

                    case 0:	dfs(num + number[idx], idx + 1);	break;
                    case 1:	dfs(num - number[idx], idx + 1);	break;
                    case 2:	dfs(num * number[idx], idx + 1);	break;
                    case 3:	dfs(num / number[idx], idx + 1);	break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
}
