package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number10808 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String target = scanner.next();
        char[] targetChar = target.toCharArray();

        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int[] answer = new int[alphabet.length];

        for(int i = 0; i < targetChar.length; i++){
            for(int j = 0; j < alphabet.length; j++){
                if(alphabet[j].equals(String.valueOf(targetChar[i]))){
                    answer[j]++;
                }
            }
        }

        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}
