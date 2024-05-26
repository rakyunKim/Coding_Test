package Programers.kakao;

import java.io.IOException;
import java.util.Arrays;

// 40분
public class CheckingSocialDistancing {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[][] places = new String[][] {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = solution(places);

        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(String[][] places) {
        // checkList
        // 응시자의 상하좌우에 다른 응시자가 있을 경우 false
        // 응시자의 대각에 다른 응시자가 있으며, 파티션으로 가려지지 않은 경우 false
        // 응시자의 한 칸 지난 상하좌우에 응시자가 있으며 파티션으로 가려지지 않은 경우

        // 일단 places 에서 P를 찾고 P를 찾을 경우
        // 상하좌우 탐색, 대각 탐색, 상하좌우 + 1 만큼 탐색

        int[] answer = new int[5];

        // 응시장은 총 5개
        for (int i = 0; i < 5; i++) {
            String[] examRoom = new String[5];

            for (int j = 0; j < 5; j++) {
                examRoom[j] = places[i][j];
            }

            if(checkTesterIn(examRoom)) answer[i] = 1;
            else answer[i] = 0;
        }


        return answer;
    }

    private static boolean checkTesterIn(String[] input) {
        char[][] examRoom = new char[5][5];

        for (int i = 0; i < 5; i++) {
            examRoom[i] = input[i].toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(examRoom[i][j] == 'P') {
                    if(!checkAllDirections(examRoom, i, j) ||
                            !checkTheDiagonal(examRoom, i, j) ||
                            !checkAllDirectionsPlusOne(examRoom, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean checkAllDirections(char[][] examRoom, int y, int x) {
        if (y + 1 < examRoom.length && examRoom[y + 1][x] == 'P') {
            return false;
        }

        if (y - 1 >= 0 && examRoom[y - 1][x] == 'P') {
            return false;
        }

        if (x + 1 < examRoom.length && examRoom[y][x + 1] == 'P') {
            return false;
        }

        if (x - 1 >= 0 && examRoom[y][x - 1] == 'P') {
            return false;
        }

        return true;
    }

    private static boolean checkTheDiagonal(char[][] examRoom, int y, int x) {
        if(y + 1 < examRoom.length
                && x + 1 < examRoom[0].length
                && examRoom[y + 1][x + 1] == 'P') {
            return examRoom[y + 1][x] == 'X' && examRoom[y][x + 1] == 'X';
        }

        if(y - 1 >= 0
                && x + 1 < examRoom[0].length
                && examRoom[y - 1][x + 1] == 'P') {
            return examRoom[y - 1][x] == 'X' && examRoom[y][x + 1] == 'X';
        }

        if(y - 1 >= 0 && x - 1 >= 0
                && examRoom[y - 1][x - 1] == 'P') {
            return examRoom[y - 1][x] == 'X' && examRoom[y][x - 1] == 'X';
        }

        if(y + 1 < examRoom.length
                && x - 1 >= 0
                && examRoom[y + 1][x - 1] == 'P') {
            return examRoom[y + 1][x] == 'X' && examRoom[y][x - 1] == 'X';
        }

        return true;
    }
    private static boolean checkAllDirectionsPlusOne(char[][] examRoom, int y, int x) {
        if (y + 2 < examRoom.length
                && examRoom[y + 2][x] == 'P'
                && examRoom[y + 1][x] != 'X') {
            return false;
        }

        if (y - 2 >= 0
                && examRoom[y - 2][x] == 'P'
                && examRoom[y - 1][x] != 'X') {
            return false;
        }

        if (x + 2 < examRoom.length
                && examRoom[y][x + 2] == 'P'
                && examRoom[y][x + 1] != 'X') {
            return false;
        }

        if (x - 2 >= 0
                && examRoom[y][x - 2] == 'P'
                && examRoom[y][x - 1] != 'X') {
            return false;
        }

        return true;
    }
}
