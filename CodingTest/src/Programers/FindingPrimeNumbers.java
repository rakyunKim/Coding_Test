package Programers;

import java.io.IOException;
import java.util.*;

public class FindingPrimeNumbers {
    static Set<Integer> set;
    static boolean[] visited = new boolean[7];

    public static void main(String[] args) throws IOException {
        String numbers = "17";
//        String numbers = "011";
//        String numbers = "1234";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        set = new HashSet<>();
        int answer = 0;
        backTracking(numbers, "", 0);

        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    private static void backTracking(String numbers, String s, int depth) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                backTracking(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }

    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        // 에라토스테네스 체
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
