package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1629 {
    static int C;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        C = scanner.nextInt();




        System.out.println(go(A,B));
    }

    private static long go(long a, long b) {
        if(b == 1) return a % C;
        long temp = go(a,b / 2);
        temp = (temp * temp) % C;
        if(b % 2 == 1){
            temp = (temp * a) % C;
        }
        return temp;
    }
}
