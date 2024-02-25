package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

/**
 * 문자열을 입력 받고 알파벳 배열에 같은 문자를 찾고
 * while 문으로 돌면서 13번째 이후에 오는 문자 출력
 * split으로 " "를 기준으로 나누어서 문자를 받음
 *
 */

public class Number11655 {
    static String[] alphabet;
    static String[] upperAlphabet;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        upperAlphabet = new String[alphabet.length]; // 대문자 알파벳 배열 생성
        sb = new StringBuilder();
        // 소문자 배열을 대문자 배열로 복사
        for (int i = 0; i < alphabet.length; i++) {
            upperAlphabet[i] = alphabet[i].toUpperCase();
        }

        String target = bf.readLine();
        String[] targetArr = target.split(" ");


        for(String temp : targetArr){
            char[] cha = temp.toCharArray();
            for(int i = 0; i < cha.length; i++){
                if(!findInLower(String.valueOf(cha[i]))){
                    if(!findInUpper(String.valueOf(cha[i]))){
                        sb.append(String.valueOf(cha[i]));
                    }
                }

            }
            sb.append(" ");
        }
        String result = sb.toString();
        System.out.println(result);
    }

    private static boolean findInUpper(String temp) {
        for(int i = 0; i < upperAlphabet.length; i++){
            if(upperAlphabet[i].equals(temp)){
                int v = i + 13;
                if(v > 25){
                    v -= 26;
                    sb.append(upperAlphabet[v]);
                } else {
                    sb.append(upperAlphabet[v]);
                }
                return true;
            }
        }
        return false;
    }

    private static boolean findInLower(String temp) {
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i].equals(temp)){
                int v = i + 13;
                if(v > 25){
                    v -= 26;
                    sb.append(alphabet[v]);
                } else {
                    sb.append(alphabet[v]);
                }
                return true;
            }
        }
        return false;
    }
}
