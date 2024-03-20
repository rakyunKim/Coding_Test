package Baekjoon.구현;

import java.io.IOException;
import java.util.Scanner;

public class Number14890 {
    public static void main(String[] args) throws IOException {
        // 한 행이나 한 열의 경사로의 값이 모두 같다면 가능
        // 경사로의 범위가 주어지는데 경사로를 두고 건너갈 수 있다면 가능
        // 단 경사로를 둘 떄는 높이의 차가 1이어야 하고, 경사로의 범위 안에 들어와야 함
        // 그리고 내가 경사로를 둔 자리에 다른 경사로가 들어올 수 없으므로 경사로를 둔 자리를 저장해야 함

        // 1. 경사로를 둘 수 있는 곳을 찾는다.
        // 2. 그곳을 중심으로 다른 경사로를 둘 수 있는 곳을 찾는다.

        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        int rampLength = scanner.nextInt();

        int[][] map = new int[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++){
            for (int x = 0; x < mapSize; x++){
                map[y][x] = scanner.nextInt();
            }
        }

        // 경사로를 두면 갈 수 있는 길인지 아닌지 체크하는 로직
        //
    }
}
