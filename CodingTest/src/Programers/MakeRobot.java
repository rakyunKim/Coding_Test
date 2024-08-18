package Programers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MakeRobot {
    static int[][] needs;
    static int r;
    static int robotCount;
    static int componentCount;
    static List<Integer> current; // 0, 1
    static int answer;
    public static void main(String[] args) throws IOException {
        needs = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        r = 2;
        int result = solution(needs, r);
        System.out.println(result);
    }

    private static int solution(int[][] needs, int r) {
        robotCount = needs.length;
        componentCount = needs[0].length;
        current = new ArrayList<>();
        // 완탐으로 0번 부품 1번 부품, 0번 부품 2번 부품 이렇게 고르고 고를 때마다
        // 총 몇개의 로봇을 만들 수 있는지 확인

        for (int i = 0; i < componentCount; i++){
            find(i);
            current.clear();
        }


        return answer;
    }

    private static void find(int start) {
        current.add(start);
        if (current.size() == r){
            answer  = Math.max(checkMaxValue(), answer);
            current.remove(r - 1);
        } else {
            for (int i = start + 1; i < componentCount; i++){
                find(i);
            }
        }
    }

    private static int checkMaxValue() {
        int count = 0;
        for (int i = 0; i < robotCount; i++){
            boolean isPossible = true;
            for (int j = 0; j < componentCount; j++){
                if (needs[i][j] == 1 && !current.contains(j)){
                    isPossible = false;
                    break;
                }
            }
            count += isPossible ? 1 : 0;
        }

        return count;
    }
}
