package Baekjoon.구현;

import java.io.IOException;
import java.util.*;

public class Number5430 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String query;
        int length;
        Deque<Integer> deque;
        String arrString;
        String[] temp;

        int testcase = scanner.nextInt();
        for (int i = 0; i < testcase; i++) {
            query = scanner.next();
            length = scanner.nextInt();
            deque = new LinkedList<>();

            arrString = scanner.next();
            arrString = arrString.substring(1, arrString.length() - 1);
            temp = arrString.split(",");

//            if (temp.length == 1 && Objects.equals(temp[0], "")) {
//                System.out.println("error");
//                continue;
//            }

            for (String s : temp) {
                if (!s.isEmpty()) {
                    deque.add(Integer.parseInt(s));
                }
            }

//            char[] queryToChar = query.toCharArray();

//            StringBuilder result = new StringBuilder();
//            boolean prevIsR = false;
//            for (char c : queryToChar) {
//                if (c == 'R') {
//                    if (!prevIsR) {
//                        prevIsR = true;
//                        result.append(c);
//                    } else {
//                        result.setLength(result.length() - 1);
//                        prevIsR = false;
//                    }
//                } else {
//                    prevIsR = false;
//                    result.append(c);
//                }
//            }
//            queryToChar = result.toString().toCharArray();

            boolean isReversed = false;
            boolean isError = false;
            for (char c : query.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }

            }

            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder("[");

                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }

                sb.append("]");
                System.out.println(sb);
            }
        }

    }
}

