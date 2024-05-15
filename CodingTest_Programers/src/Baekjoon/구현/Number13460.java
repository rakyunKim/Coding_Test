package Baekjoon.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number13460 {
    static int garo;
    static int sero;
    static String[][] map;
    static int[] red;
    static int[] blue;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        garo = scanner.nextInt();
        sero = scanner.nextInt();

        map = new String[sero][garo];

        for (int i = 0; i < sero; i++) {
            String input = scanner.next();
            char[] split = input.toCharArray();
            for (int j = 0; j < garo; j++) {
                map[i][j] = String.valueOf(split[j]);

                if (split[j] == 'R') {
                    red = new int[]{i, j};
                }

                if (split[j] == 'B') {
                    red = new int[]{i, j};
                }
            }
        }

        /*
        * 위 아래 오른쪽 왼쪽 중에 내가 방금 왔던 방향은 제외하고
        * 갈 수 있는 모든 방향으로 모두 DFS()를 수행
        * 이동은 벽이 나올때까지 그 방향으로 쭉 가야 함
        * 이동 할 떄마다 파란색 구슬과 빨간색 구슬 모두 체크
        * 나올 수 있는 모든 경우의 수에서 모두 -1이 나온다면 -1 출력
        * 아니라면 가장 숫자가 적은 수 출력
        * */

        /* 0 == 아래, 1 == 위에, -1 == 오른쪽, -2 == 왼쪽 */


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            int nextRedY = red[0] + dy[i];
            int nextRedX = red[1] + dx[i];

            if (nextRedY < sero && nextRedY >= 0 &&
                    nextRedX < garo && nextRedX >= 0 &&
                    !map[nextRedY][nextRedX].equals("#") &&
                    !map[nextRedY][nextRedX].equals("B"))
            {

                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int way = queue.poll();


        }


        System.out.println();



//        for(int i = 0; i < sero; i++) {
//            for (int j = 0; j < garo; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

    }

    private static int DFS(int[] red, int[] blue, int way, int count) {
        if (map[red[0]][red[1]].equals("O")) return count;


        else if (way == 0 && red[0] + 1 < sero - 1) {
            if (map[red[0] + 1][red[1]].equals(".") && !map[blue[0] + 1][blue[1]].equals("O")) {
                if (map[blue[0] + 1][blue[1]].equals(".")) {
                    return DFS(new int[]{red[0] + 1, red[1]}, new int[]{blue[0] + 1, blue[1]}, way, count + 1);
                }
                else  return DFS(new int[]{red[0] + 1, red[1]}, new int[]{blue[0], blue[1]}, way, count + 1);
            }
        }

        else if (way == 1 && red[0] - 1 >= 1) {
            if (map[red[0] - 1][red[1]].equals(".") && !map[blue[0] - 1][blue[1]].equals("O")) {
                if (map[blue[0] - 1][blue[1]].equals(".")) {
                    return DFS(new int[]{red[0] - 1, red[1]}, new int[]{blue[0] - 1, blue[1]}, way, count + 1);
                }
                else return DFS(new int[]{red[0] - 1, red[1]}, new int[]{blue[0], blue[1]}, way, count + 1);
            }
        }

        else if (way == 2 && red[1] + 1 < garo - 1) {
            if (map[red[0]][red[1] + 1].equals(".") && !map[blue[0]][blue[1] + 1].equals("O")) {
                if (map[blue[0]][blue[1] + 1].equals(".")) {
                    return DFS(new int[]{red[0], red[1] + 1}, new int[]{blue[0], blue[1] + 1}, way, count + 1);
                }
                else return DFS(new int[]{red[0], red[1] + 1}, new int[]{blue[0], blue[1]}, way, count + 1);
            }
        }

        else if (way == 0 && red[1] - 1 >= 1) {
            if (map[red[0]][red[1] - 1].equals(".") && !map[blue[0]][blue[1] - 1].equals("O")) {
                if (map[blue[0]][blue[1] - 1].equals(".")) {
                    return DFS(new int[]{red[0], red[1] - 1}, new int[]{blue[0], blue[1] - 1}, way, count + 1);
                }
                else return DFS(new int[]{red[0], red[1] - 1}, new int[]{blue[0], blue[1]}, way, count + 1);
            }
        }

        return -1;
    }
}
