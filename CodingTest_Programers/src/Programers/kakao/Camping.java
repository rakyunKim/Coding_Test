package Programers.kakao;

import java.io.IOException;
import java.util.Arrays;

public class Camping {
    public static void main(String[] args) throws IOException {
        int n = 4;
        int[][] data = new int[][]{
                {0, 0},
                {1, 1},
                {0, 2},
                {2, 0}
        };
        System.out.println(solution(n, data));
    }

    public static int solution(int n, int[][] data) {
        Arrays.sort(data, (a,b) -> b[0] - a[0]);
        int maxY = data[0][0] + 1;


        Arrays.sort(data, (a,b) -> b[1] - a[1]);
        int maxX = data[0][1] + 1;

        int[][] map = new int[maxY][maxX];
        for (int[] row : data) {
            int y = row[0];
            int x = row[1];
            map[y][x] = 1;
        }

        // y축, x축 모두 +1 이상인 곳을 탐색하며 1을 찾는다.
        // 1을 찾았을 경우 조건에 맞는 곳인지 확인하고 맞다면 answer++;

//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


        int answer = 0;
        return answer;
    }
}
