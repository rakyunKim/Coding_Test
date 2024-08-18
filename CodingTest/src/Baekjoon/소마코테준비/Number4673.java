package Baekjoon.소마코테준비;

import java.util.*;

public class Number4673 {
    public static void main(String[] args) {
        List<Integer> haveConstructor = new ArrayList<>();
        for(int i = 1; i < 10000; i++){
            String numberString = String.valueOf(i);
            int[] arr = new int[numberString.length()];
            for (int j = 0; j < numberString.length(); j++) {
                char c = numberString.charAt(j);
                arr[j] = Character.getNumericValue(c);
            }
            int constructor = i;
            for(int j = 0; j < arr.length; j++){
                constructor += arr[j];
            }
            haveConstructor.add(constructor);
        }

        for(int i = 1;  i < 10000; i++){
            if(!haveConstructor.contains(i)){
                System.out.println(i);
            }
        }
    }
}
