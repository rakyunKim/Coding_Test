package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/**
 *
 * 짝짓기, 쌍 짓기, 폭발인 경우 stack 자료 구조를 생각해야 함
 */


public class Number3986 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int stringCount = scanner.nextInt();
        String[] input = new String[stringCount];

        for(int i = 0; i < stringCount; i++){
            input[i] = scanner.next();
        }

        int answer = 0;
        for(int i = 0; i < stringCount; i++){
            String target = input[i];
            if(target.length() % 2 == 0){
                Stack<String> stack = new Stack<>();
                char[] temp = target.toCharArray();


                for(int j = 0; j < temp.length; j++){
                    if(stack.isEmpty()){
                        stack.add(String.valueOf(temp[j]));
                    } else {
                        String past = stack.peek();
                        String current = String.valueOf(temp[j]);

                        if(past.equals(current)){
                            stack.pop();
                        } else {
                            stack.add(current);
                        }
                    }
                }
                if(stack.isEmpty()) answer++;
            }

        }
        System.out.println(answer);
    }
}
