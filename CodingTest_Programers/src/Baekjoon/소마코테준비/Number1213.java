package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1213 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        char[] names = name.toCharArray();
        Arrays.sort(names);
        char[] answer = new char[names.length];
        int answerCount = 0;
        int mid = name.length() / 2;
        int count = 0;
        for(int i = 0; i < names.length; i++){
            if(i == names.length - 2){
                if(names[i] == names[i + 1]){
                    answer[answerCount] = names[i];
                    answer[(name.length() - 1) - answerCount] = names[i + 1];
                    break;
                }
            }
            else if(i == names.length - 1){
                if(names[i] != names[i - 1]){
                    answer[mid] = names[i];
                    count ++;
                }
            }
            else if(names[i] == names[i + 1]){
                answer[answerCount] = names[i];
                answer[(name.length() - 1) - answerCount] = names[i + 1];
                i++;
                answerCount++;
            }
            else{
                answer[mid] = names[i];
                count++;
            }
        }

        if(count > 1){
            System.out.println("I'm Sorry Hansoo");
        }else{
            for(int i = 0; i < name.length(); i++){
                System.out.print(answer[i]);
            }
        }
    }
}
