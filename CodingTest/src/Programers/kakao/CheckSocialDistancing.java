package Programers.kakao;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckSocialDistancing {
    public static void main(String[] args) throws IOException {
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
        // 1. P를 찾는다.
        // 2. P를 찾았다면 bfs() 함수를 실행한다.
        //      2-1. bfs() 함수 내에서 위, 오른쪽, 아래, 왼쪽을 탐색한다. 그 중에 하나라도 P가 나온다면 false를 리턴하고
        // 아니라면, 탐색을 계속 진행한다. 그러다 O가 나오면 그 부분을 중심으로 다시 왼쪽, 오른쪽, 앞을 탐색한다. 이 때에도 P가 나온다면 false를 리턴,
        // 아니라면, 탐색을 계속 진행한다. 모든 구역의 탐색이 끝나면 true를 리턴한다. 그리고 만약 탐색 부분에서 상하좌우가 모두 X라면 바로 true를 리턴한다.

        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            char[][] place = new char[5][5];
            for (int j = 0; j < places[0].length; j++) {
                char[] temp = places[i][j].toCharArray();
                for (int k = 0; k < temp.length; k++) {
                    place[j][k] = temp[k];
                }
            }

            answer[i] = checkSocialDistancing(place) ? 1 : 0;
        }

        return answer;
    }

    private static boolean checkSocialDistancing(char[][] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length; j++) {
                if (place[i][j] == 'P') {
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean bfs(char[][] place, int y, int x) {
        int[][] visited = new int[place.length][place[0].length];
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = 1;

        if (y + 1 < place.length && visited[y + 1][x] == 0) {
            if (place[y + 1][x] == 'P') return false;
            if (place[y + 1][x] == 'O') queue.add(new int[]{y + 1, x});
        }
        if (y - 1 >= 0 && visited[y - 1][x] == 0) {
            if (place[y - 1][x] == 'P') return false;
            if (place[y - 1][x] == 'O') queue.add(new int[]{y - 1, x});
        }
        if (x + 1 < place[0].length && visited[y][x + 1] == 0) {
            if (place[y][x + 1] == 'P') return false;
            if (place[y][x + 1] == 'O') queue.add(new int[]{y, x + 1});
        }
        if (x - 1 >= 0 && visited[y][x - 1] == 0) {
            if (place[y][x - 1] == 'P') return false;
            if (place[y][x - 1] == 'O') queue.add(new int[]{y, x - 1});
        }


        while(!queue.isEmpty()) {
            int[] point = queue.poll();

            int currentY = point[0];
            int currentX = point[1];

            visited[currentY][currentX] = 1;

            if (currentY + 1 < place.length && visited[currentY + 1][currentX] == 0) {
                if (place[currentY + 1][currentX] == 'P') return false;
            }
            if (currentY - 1 >= 0 && visited[currentY - 1][currentX] == 0) {
                if (place[currentY - 1][currentX] == 'P') return false;
            }
            if (currentX + 1 < place[0].length && visited[currentY][currentX + 1] == 0) {
                if (place[currentY][currentX + 1] == 'P') return false;
            }
            if (currentX - 1 >= 0 && visited[currentY][currentX - 1] == 0) {
                if (place[currentY][currentX - 1] == 'P') return false;
            }

        }
        return true;
    }

//    public static void print(char[][] place) {
//        for (int i = 0; i < place.length; i++) {
//            for (int j = 0; j < place[0].length; j++) {
//                System.out.print(place[i][j]);
//            }
//            System.out.println();
//        }
//    }
}

