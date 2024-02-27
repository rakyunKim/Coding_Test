package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/**
 * 같은 문자가 있는 인덱스끼리의 범위가 다른 문자의 짝의 범위와 겹친다면 안 됨
 * 문자가 홀수이면 안 됨
 * ex 0, 3에 A가 있고 1, 2에 B가 있을 때는 범위가 겹치지 않으므로 통과
 * 0, 3에 A가 있고, 2와 4에 B가 있다면 범위가 겹치므로 실패
 * 즉 B의 start가 A안에 있다면 B의 end도 A안에 있어야 함
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
            int count = 0;

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
                            count++;
                        } else {
                            stack.add(current);
                        }
                    }
                }
            }
            if(count == target.length() / 2) answer++;
        }
        System.out.println(answer);
    }
}
