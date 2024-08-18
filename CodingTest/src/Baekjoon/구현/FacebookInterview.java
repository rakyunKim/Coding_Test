package Baekjoon.구현;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FacebookInterview {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);

        String target = scanner.next();
        char[] temp = target.toCharArray();

        List<String> str = new ArrayList<>();
        int total = 0;

        for (char c : temp) {
            if(Character.isDigit(c)){
                total += (Integer.parseInt(String.valueOf(c)));
            } else {
                str.add(String.valueOf(c));
            }
        }

        Collections.sort(str);
        for(String a : str){
            System.out.print(a);
        }
        System.out.print(total);
    }
}
