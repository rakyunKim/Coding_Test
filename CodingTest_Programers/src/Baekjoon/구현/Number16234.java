package Baekjoon.구현;//package Baekjoon.구현;
//
//import java.util.*;
//
//public class Number16234 {
//    static int mapSize;
//    static int[][] map;
//    static int[][] visited;
//    static int Min;
//    static int Max;
//    static int[] dy = new int[]{1, -1, 0, 0};
//    static int[] dx = new int[]{0, 0, 1, -1};
//    static Queue<int[]> shouldMove = new LinkedList<>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        mapSize = scanner.nextInt();
//        map = new int[mapSize][mapSize];
//
//        Min = scanner.nextInt();
//        Max = scanner.nextInt();
//
//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                map[i][j] = scanner.nextInt();
//            }
//        }
//
//        int answer = 0;
//        isCanMove();
//
//        while(!shouldMove.isEmpty()) {
//            answer++;
//            visited = new int[mapSize][mapSize];
//            int[] nextTarget;
//
//
//            while(!shouldMove.isEmpty()) {
//                nextTarget = shouldMove.poll();
//
//                if (visited[nextTarget[0]][nextTarget[1]] == 0) {
//                    BFS(nextTarget[0], nextTarget[1]);
//                }
//            }
//
//            isCanMove();
//        }
//
//        System.out.println(answer);
//    }
//
//    private static void isCanMove() {
//        int differenceValue;
//        boolean isPossible;
//
//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                isPossible = false;
//                if (i + 1 < mapSize) {
//                    differenceValue = Math.abs(map[i][j] - map[i + 1][j]);
//                    if (differenceValue >= Min && differenceValue <= Max) {
//                        isPossible = true;
//                    }
//                }
//
//                if (j + 1 < mapSize) {
//                    differenceValue = Math.abs(map[i][j] - map[i][j + 1]);
//                    if (differenceValue >= Min && differenceValue <= Max) {
//                        isPossible = true;
//                    }
//                }
//                if (isPossible) shouldMove.add(new int[]{i, j});
//            }
//        }
//    }
//
//    private static void BFS(int y, int x) {
//        Queue<int[]> queue = new LinkedList<>();
//
//        int total = map[y][x];
//        int townCount = 1;
//        queue.add(new int[]{y, x});
//        visited[y][x] = 1;
//
//        while(!queue.isEmpty()) {
//            int[] current = queue.poll();
//            y = current[0];
//            x = current[1];
//
//            for (int i = 0; i < 4; i ++) {
//                int nextY = y + dy[i];
//                int nextX = x + dx[i];
//
//                if (nextY < mapSize && nextY >= 0 &&
//                        nextX < mapSize && nextX >= 0 &&
//                        visited[nextY][nextX] == 0) {
//                    int differenceValue = Math.abs(map[y][x] - map[nextY][nextX]);
//                    if (differenceValue >= Min && differenceValue <= Max) {
//                        total += map[nextY][nextX];
//                        townCount++;
//                        visited[nextY][nextX] = 1;
//                        queue.add(new int[]{nextY, nextX});
//                    }
//                }
//            }
//
//        }
//
//        int avg = total / townCount;
//
//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                if (visited[i][j] == 1) {
//                    map[i][j] = avg;
//                }
//            }
//        }
//    }
//}
import java.util.*;

public class Number16234 {

    static int n, l, r;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Node> list; //인구 이동이 필요한 노드 리스트

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        l = scan.nextInt();
        r = scan.nextInt();

        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
            }
        }

        System.out.println(move());
    }

    public static int move() { //더 이상 인구이동이 일어나지 않을 때까지 반복
        int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); //bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        if(list.size() > 1) {
                            changePopulation(sum); //열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove) return result;;
            result++;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = board[x][y];
        while(!q.isEmpty()) {
            Node current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(board[current.x][current.y] - board[nx][ny]);
                    if(l <= diff && diff <= r) {
                        q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += board[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return sum;
    }

    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Node n : list) {
            board[n.x][n.y] = avg;
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
