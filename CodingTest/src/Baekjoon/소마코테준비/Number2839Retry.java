package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number2839Retry {
    static int sugarWeight;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        sugarWeight = scanner.nextInt();
        int quotient = 0;
        int answer = 0;

        if(sugarWeight >= 5){
            quotient = sugarWeight / 5;
            if(sugarWeight - (quotient * 5) != 0){
                answer = divisionFive(quotient);
            }else{
                answer = quotient;
            }
        } else{
            if(sugarWeight % 3 == 0){
                answer = sugarWeight / 3;
            } else{
                answer = -1;
            }
        }

        System.out.println(answer);
    }

    private static int divisionFive(int quotient) {
        if((sugarWeight - (quotient * 5)) % 3 == 0){
            return quotient + (sugarWeight - (quotient * 5)) / 3;
        }else{
            if(quotient - 1 >= 0){
                return divisionFive(quotient - 1);
            } else{
                return -1;
            }
        }

    }
}
