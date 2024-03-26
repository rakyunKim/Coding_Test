package Programers;

import java.io.IOException;

public class DroppingBeads {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        String[] drum = new String[]{
                "######",
                ">#*###",
                "####*#",
                "#<#>>#",
                ">#*#*<",
                "######"
        };

        int result = solution(drum);
        System.out.println(result);
    }


    //        for (int i = 0; i < ySize; i++){
//            for (int j = 0; j < xSize; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

    private static int solution(String[] drum) {
        // drum의 길이는 최대 10의 3승이므로 for문 두 개를 사용해서 탐색 가능
        // for문은 y축의 길이만큼 하나 돌면서 구슬을 떨어뜨리는 함수 실행

        int ySize = drum.length;
        int xSize = drum[0].length();
        map = new char[ySize][xSize];
        for (int i = 0; i < ySize; i++){
            char[] temp = drum[i].toCharArray();
            for (int j = 0; j < xSize; j++){
                map[i][j] = temp[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < ySize; i++){
            answer += dropping(0, i, 0) ? 1 : 0;
        }


        return answer;
    }

    private static boolean dropping(int startY, int startX, int starCount) {

        if (map[startY][startX] == '#' && startY + 1 >= map.length) {
            return true;
        } else if (map[startY][startX] == '#' && startY + 1 < map.length) {
            return dropping(startY + 1, startX, starCount);
        }

        else if (map[startY][startX] == '>' && startX + 1 < map[0].length) {
            return dropping(startY, startX + 1, starCount);
        } else if (map[startY][startX] == '>' && startX + 1 >= map[0].length) {
            return false;
        }

        else if (map[startY][startX] == '<' && startX - 1 >= 0) {
            return dropping(startY, startX - 1, starCount);
        } else if (map[startY][startX] == '<' && startX - 1 < 0) {
            return false;
        }

        else if (map[startY][startX] == '*' && starCount == 0 && startY + 1 >= map.length) {
            return true;
        } else if (map[startY][startX] == '*' && starCount == 0 && startY + 1 < map.length) {
            return dropping(startY + 1, startX, starCount + 1);
        } else {
            return false;
        }
    }
}
