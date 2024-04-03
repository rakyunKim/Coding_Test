package Programers.kakao;

import java.io.IOException;

public class SteppingStones {
    public static void main(String[] args) throws IOException {
        int[] stones = new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int result = solution(stones, k);

        System.out.println("==========================");
        System.out.println("정답 :: " + result);
    }
    public static int solution(int[] stones, int k) {
        int[] dp = new int[stones.length];
        int rangeStart = 0;
        int rangeEnd = k - 1;

        int maxValueInRange = 0;
        for (int i = 0; i < k; i++) {
            dp[i] = stones[i];
            maxValueInRange = Math.max(maxValueInRange, stones[i]);
        }

        for (int i = k; i < stones.length; i++) {

            if (maxValueInRange > stones[i]) {
                dp[i] = stones[i];
            } else {
                dp[i] = maxValueInRange;
            }

            if (i != stones.length - 1) {
                if (stones[rangeStart] == maxValueInRange) {
                    maxValueInRange = 0;
                    for (int j = i ; j > i - k; j--) {
                        maxValueInRange = Math.max(maxValueInRange, dp[j]);
                    }
                }
                rangeStart ++;
                rangeEnd ++;
                if (rangeEnd < stones.length && stones[rangeEnd] > maxValueInRange) {
                    maxValueInRange = dp[rangeEnd];
                }
            }
        }

        int answer = 0;
        for (int i = stones.length - 1; i >= stones.length - k; i--) {
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
