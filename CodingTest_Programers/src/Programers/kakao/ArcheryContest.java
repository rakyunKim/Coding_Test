package Programers.kakao;

import java.io.IOException;
import java.util.*;
public class ArcheryContest {
    static int maxScore = 0;
    static Map<Integer, int[]> score = new HashMap<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = 5;
//        int n = 1;
//        int n = 9;
//        int n = 10;

        int[] info = new int[]{2,1,1,1,0,0,0,0,0,0,0};
//        int[] info = new int[]{1,0,0,0,0,0,0,0,0,0,0};
//        int[] info = new int[]{0,0,1,2,0,1,1,1,1,1,1};
//        int[] info = new int[]{0,0,0,0,0,0,0,0,3,4,3};

        int[] result = solution(n, info);

        for (int i : result) {
            System.out.print(i + ", ");
        }
    }

    public static int[] solution(int n, int[] info) {
        // 이기거나 지거나 2가지 경우가 나온다.
        // 10개의 경우에서 이기거나 지거나 2가지 경우가 나오는데,
        // 총 경우의 수를 모두 계산한다고 해도 1000개 정도인거 같다.
        // 그럼 인자로 주어지는 info 배열을 순회하면서 지는 경우 이기는 경우 2가지 경우에서 가장 큰 값을 리턴하면 되겠다.

        bruteForce(n, info, new int[info.length], 0);

        if (score.get(maxScore) == null) return new int[]{-1};

        return score.get(maxScore);
    }

    private static void bruteForce(int arrowsCount, int[] apeach, int[] ryon, int currentDepth) {
        if (currentDepth > 10) {
            int currentScore = getScore(ryon, apeach);
            if (currentScore > maxScore) {
                maxScore = currentScore;
                int[] ryonClone = ryon.clone();

                if (arrowsCount != 0) {
                    ryonClone[10] = arrowsCount;
                }

                score.put(currentScore, ryonClone);
            } else if (currentScore == maxScore && maxScore != 0) {
                int[] maxRyon = score.get(maxScore);

                score.put(maxScore, compareRowScore(maxRyon, ryon).clone());
            }
        }
        else {
            // 라이언이 이번 라운드에서 이기는 경우
            if (arrowsCount > apeach[currentDepth]) {
                ryon[currentDepth] = apeach[currentDepth] + 1;
                bruteForce(arrowsCount - ryon[currentDepth], apeach, ryon, currentDepth + 1);
                ryon[currentDepth] = 0;
            }
            
            // 라이언이 이번 라운드에서 지는 경우
            bruteForce(arrowsCount, apeach, ryon, currentDepth + 1);
        }
    }

    private static int getScore(int[] ryon, int[] apeach) {
        int ryonScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            if (ryon[i] > apeach[i]) ryonScore += 10 - i;
            else if (apeach[i] > ryon[i]) apeachScore += 10 - i;
        }

        if (ryonScore > apeachScore) return ryonScore - apeachScore;
        else return 0;
    }

    private static int[] compareRowScore(int[] maxRyon, int[] currentRyon) {
        for (int i = 10; i >= 0; i--) {
            if (maxRyon[i] == 0 && currentRyon[i] != 0) return currentRyon;
            else if (maxRyon[i] != 0 && currentRyon[i] == 0) return maxRyon;
        }

        return maxRyon;
    }


}
