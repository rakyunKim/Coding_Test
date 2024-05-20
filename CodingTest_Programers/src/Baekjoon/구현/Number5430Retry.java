package Baekjoon.구현;

import java.util.*;

public class Number5430Retry {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for(int t = 0; t < testCaseCount; t++) {
            char[] query = scanner.next().toCharArray();
            int arrLength = scanner.nextInt();
            Deque<Integer> deque = new ArrayDeque<>();

            String input = scanner.next();
            input = input.substring(1, input.length() - 1);
            String[] temp = input.split(",");

            if(!temp[0].isEmpty()) {
                for(int i = 0; i < temp.length; i++) {
                    deque.add(Integer.parseInt(temp[i]));
                }
            }

            boolean isPossible = true;
            boolean isFront = true;
            for(int i = 0; i < query.length; i++) {
                if(query[i] == 'R') {
                    isFront = !isFront;
                }
                else {
                    if(deque.isEmpty()) {
                        isPossible = false;
                        break;
                    }

                    if(isFront) {
                        deque.pollFirst();
                    }

                    if(!isFront) {
                        deque.pollLast();
                    }
                }
            }

            if(!isPossible) System.out.println("error");
            else
            {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!deque.isEmpty()) {
                    if(isFront) sb.append(deque.pollFirst());
                    else sb.append(deque.pollLast());
                    if(!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }

    }
}
