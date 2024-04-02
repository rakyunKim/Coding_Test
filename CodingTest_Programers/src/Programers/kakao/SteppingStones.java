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
        // k만큼 앞을 보고 만약 나보다 작다면 작은 수로 answer을 초기화
        // 그게 아니라면 현재의 수로 answer을 계속 두면서 앞으로 전진


        int answer = 0;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (answer < stones[i]) {
                answer = stones[i];
                maxIndex = i;
            }
        }

        for (int i = maxIndex; i < stones.length; i++) {
            if (i + k >= stones.length) {
                break;
            } else {
                int max = 0;
                maxIndex = 0;
                for (int j = i + 1; j <= i + k; j++) {
                    if (max < stones[j]) {
                        max = stones[j];
                        maxIndex = j;
                    }
                }
                if (max < answer) {
                    answer = max;
                }
                i = maxIndex;
            }
        }


        return answer;
    }
}
