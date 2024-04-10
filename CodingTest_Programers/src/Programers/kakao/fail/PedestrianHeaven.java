package Programers.kakao.fail;

import java.io.IOException;

public class PedestrianHeaven {
    static int MOD = 20170805;
    static int answer;
    static int maxY;
    static int maxX;
    public static void main(String[] args) throws IOException {
        int m = 3;

//        int n = 3;
        int n = 6;

//        int[][] cityMap = new int[][]{
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        };

        int[][] cityMap = new int[][]{
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        };

        System.out.println(solution(m, n, cityMap));
    }
    public static int solution(int m, int n, int[][] cityMap) {
        // 내가 오던 방향이 필요
        // 현재 내 위치 필요
        maxY = m;
        maxX = n;
        answer = 0;

        searchPath(new int[]{0,0}, new int[]{0,0}, cityMap);

        return answer % MOD;
    }

    private static void searchPath(int[] current, int[] pastWay, int[][] cityMap){
        // pastWay가 1일 경우 y축++
        // pastWay가 2일 경우 x축++
        int currentY = current[0];
        int currentX = current[1];
        if (currentY == maxY - 1 && currentX == maxX - 1) {
            answer++;
        } else {
            if (cityMap[currentY][currentX] == 2) {
                if (currentY + pastWay[0] < maxY && currentX + pastWay[1] < maxX && cityMap[currentY + pastWay[0]][currentX + pastWay[1]] != 1) {
                    searchPath(new int[]{currentY + pastWay[0], currentX + pastWay[1]}, pastWay, cityMap);
                }
            } else {
                // y축 이동
                if (currentY + 1 < maxY && cityMap[currentY + 1][currentX] != 1) {
                    searchPath(new int[]{currentY + 1, currentX}, new int[]{1, 0}, cityMap);
                }

                // x축 이동
                if (currentX + 1 < maxX && cityMap[currentY][currentX + 1] != 1) {
                    searchPath(new int[]{currentY, currentX + 1}, new int[]{0, 1}, cityMap);
                }
            }
        }
    }
}
