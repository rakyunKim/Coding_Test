package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class KakaoFriendsColoringBook {
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        int m = 6;
        int n = 4;

        int[][] picture = new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
//        int[][] picture = new int[][]{
//                {1, 1, 1, 0},
//                {1, 1, 1, 0},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1}
//        };

//                int[][] picture = new int[][]{
//                {1, 1, 1, 4},
//                {2, 1, 1, 4},
//                {2, 0, 5, 3},
//                {2, 2, 5, 3},
//                {0, 2, 0, 3},
//                {0, 2, 2, 3}
//        };


        System.out.println(Arrays.toString(solution(m, n, picture)));
    }

    public static int[] solution(int maxY, int maxX, int[][] picture) {
        // 영역은 리스트로 영역의 번호가 리스트에 인덱스가 되어 인덱스의 값을 넣음
        // 가장 값이 큰 인덱스를 answer[1]에 넣고 리스트의 사이즈를 answer[0]에 넣음
        // for문을 돌면서 0이 아닌 경우에 dfs() 실행
        // Dfs() 인자로는 현재의 번호와 그 번호의 개수

        visited = new int[maxY][maxX];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (picture[i][j] != 0 && visited[i][j] == 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(int y, int x, int[][] picture) {
        int totalCount = 1;
        visited[y][x] = 1;
        Queue<int[]> queue = new LinkedList<>();
        int target = picture[y][x];
        if (y + 1 < picture.length && visited[y + 1][x] != 1 && picture[y + 1][x] == target) {
            queue.add(new int[]{y + 1, x});
            visited[y + 1][x] = 1;
            totalCount++;
        }
        if (y - 1 >= 0 && visited[y - 1][x] != 1 && picture[y - 1][x] == target) {
            queue.add(new int[]{y - 1, x});
            visited[y - 1][x] = 1;
            totalCount++;
        }
        if (x + 1 < picture[0].length && visited[y][x + 1] != 1 && picture[y][x + 1] == target) {
            queue.add(new int[]{y, x + 1});
            visited[y][x + 1] = 1;
            totalCount++;
        }
        if (x - 1 >= 0 && visited[y][x - 1] != 1 && picture[y][x - 1] == target) {
            queue.add(new int[]{y, x - 1});
            visited[y][x - 1] = 1;
            totalCount++;
        }

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int currentY = point[0];
            int currentX = point[1];

            if (currentY + 1 < picture.length && visited[currentY + 1][currentX] != 1 && picture[currentY + 1][currentX] == target) {
                queue.add(new int[]{currentY + 1, currentX});
                visited[currentY + 1][currentX] = 1;
                totalCount++;
            }
            if (currentY - 1 >= 0 && visited[currentY - 1][currentX] != 1 && picture[currentY - 1][currentX] == target) {
                queue.add(new int[]{currentY - 1, currentX});
                visited[currentY - 1][currentX] = 1;
                totalCount++;
            }
            if (currentX + 1 < picture[0].length && visited[currentY][currentX + 1] != 1 && picture[currentY][currentX + 1] == target) {
                queue.add(new int[]{currentY, currentX + 1});
                visited[currentY][currentX + 1] = 1;
                totalCount++;
            }
            if (currentX - 1 >= 0 && visited[currentY][currentX - 1] != 1 && picture[currentY][currentX - 1] == target) {
                queue.add(new int[]{currentY, currentX - 1});
                visited[currentY][currentX - 1] = 1;
                totalCount++;
            }
        }

        return totalCount;
    }
}
