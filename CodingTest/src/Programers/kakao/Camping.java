package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class Camping {
    static int[][] map;
    public static void main(String[] args) throws IOException {
//        int n = 4;
        int n = 10;
//        int[][] data = new int[][]{
//                {0, 0},
//                {1, 1},
//                {0, 2},
//                {2, 0}
//        };
        int[][] data = new int[][]{
                {0, 0},
                {1, 1},
                {0, 2},
                {2, 0},
                {3, 0},
                {4, 1},
                {2, 2},
                {2, 1},
                {4, 2},
                {3, 1}
        };
        System.out.println(solution(n, data));
    }

    public static int solution(int n, int[][] data) {
        Arrays.sort(data, (a,b) -> b[0] - a[0]);
        int maxY = data[0][0] + 1;


        Arrays.sort(data, (a,b) -> b[1] - a[1]);
        int maxX = data[0][1] + 1;

        map = new int[maxY][maxX];
        for (int[] row : data) {
            int y = row[0];
            int x = row[1];
            map[y][x] = 1;
        }

        int answer = 0;
        // y축, x축 모두 +1 이상인 곳을 탐색하며 1을 찾는다.
        // 1을 찾았을 경우 조건에 맞는 곳인지 확인하고 맞다면 answer++;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    if (backTracking(i, j)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean backTracking(int y, int x) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i != y && j != x && map[i][j] == 1) {
                    int[] yPoint = new int[]{Math.max(y, i), Math.min(y, i)};
                    int[] xPoint = new int[]{Math.max(x, j), Math.min(x, j)};
                    if (checkTentPeg(yPoint, xPoint)) {
                        map[y][x] = 2;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkTentPeg(int[] yPoint, int[] xPoint) {
        for (int i = yPoint[1] + 1; i <= yPoint[0]; i++) {
            for (int j = xPoint[1] + 1; j <= xPoint[1]; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
