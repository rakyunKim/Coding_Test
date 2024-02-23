package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bf.readLine());

        String[] word = new String[wordCount];
        for(int i = 0; i < wordCount; i++){
            word[i] = bf.readLine();
        }


        Arrays.sort(word);
        Arrays.sort(word, (e1, e2) -> {
            return e1.length() - e2.length();
        });
        Set<String> set = new LinkedHashSet<>(Arrays.asList(word));



        for(String a : set){
            System.out.println(a);
        }

    }
}
