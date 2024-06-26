package Baekjoon.구현;

import java.util.*;

public class Number12100 {
    static int mapSize;
    static int MAX = 0;
    public static void main(String[] args) throws Exception {
        /*
            한 번 움직일 때마다 4번의 경우의 수가 생김
            한 번 움직일 때마다 맵 안에서 가장 큰 수를 찾고 그 수로 Max의 값을 갱신함
            움직인 횟수가 5번이 되면 함수를 중단함
         */

        Scanner scanner = new Scanner(System.in);
        mapSize = scanner.nextInt();
        int[][] map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        bruteForce(map, 0);

        System.out.println(MAX);

//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void bruteForce(int[][] map, int count) {
        if (count == 5) {
            return;
        }

        int[][] copyMap = Arrays.stream(map)
                        .map(int[]::clone)
                        .toArray(int[][]::new);
        Queue<Integer> queue = new LinkedList<>();
        moveLeft(copyMap, queue);
        bruteForce(copyMap, count + 1);

        copyMap = Arrays.stream(map)
                .map(int[]::clone)
                .toArray(int[][]::new);
        queue = new LinkedList<>();
        moveRight(copyMap, queue);
        bruteForce(copyMap, count + 1);

        copyMap = Arrays.stream(map)
                .map(int[]::clone)
                .toArray(int[][]::new);
        queue = new LinkedList<>();
        moveOver(copyMap, queue);
        bruteForce(copyMap, count + 1);

        copyMap = Arrays.stream(map)
                .map(int[]::clone)
                .toArray(int[][]::new);
        queue = new LinkedList<>();
        moveUnder(copyMap, queue);
        bruteForce(copyMap, count + 1);
    }

    private static void moveUnder(int[][] map, Queue<Integer> queue) {
        for (int x = 0; x < mapSize; x++) {
            for (int y = mapSize - 1; y >= 0; y--) {
                if (map[y][x] != 0) {
                    queue.add(map[y][x]);
                    map[y][x] = 0;
                }
            }

            int currentPtr = mapSize - 1;
            int first = 0;
            int second = 0;
            while (queue.size() > 1) {
                first = queue.poll();
                second = queue.peek();

                if (first == second) {
                    queue.poll();
                    map[currentPtr][x] = first + second;
                    currentPtr--;
                }
                else {
                    map[currentPtr][x] = first;
                    currentPtr--;
                }
            }

            if (!queue.isEmpty()) {
                map[currentPtr][x] = queue.poll();
            }
        }

//        printMap(map, 4);
        MAX = Math.max(MAX, getMaxValue(map));
    }

    private static void moveOver(int[][] map, Queue<Integer> queue) {
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                if (map[y][x] != 0) {
                    queue.add(map[y][x]);
                    map[y][x] = 0;
                }
            }

            int currentPtr = 0;
            int first = 0;
            int second = 0;
            while (queue.size() > 1) {
                first = queue.poll();
                second = queue.peek();

                if (first == second) {
                    queue.poll();
                    map[currentPtr][x] = first + second;
                    currentPtr++;
                }
                else {
                    map[currentPtr][x] = first;
                    currentPtr++;
                }
            }

            if (!queue.isEmpty()) {
                map[currentPtr][x] = queue.poll();
            }
        }

//        printMap(map, 3);
        MAX = Math.max(MAX, getMaxValue(map));
    }

    private static void moveRight(int[][] map, Queue<Integer> queue) {
        for (int y = 0; y < mapSize; y++) {
            for (int x = mapSize - 1; x >= 0; x--) {
                if (map[y][x] != 0) {
                    queue.add(map[y][x]);
                    map[y][x] = 0;
                }
            }

            int currentPtr = mapSize - 1;
            int first = 0;
            int second = 0;
            while (queue.size() > 1) {
                first = queue.poll();
                second = queue.peek();

                if (first == second) {
                    queue.poll();
                    map[y][currentPtr] = first + second;
                    currentPtr--;
                }
                else {
                    map[y][currentPtr] = first;
                    currentPtr--;
                }
            }

            if (!queue.isEmpty()) {
                map[y][currentPtr] = queue.poll();
            }
        }

//        printMap(map, 2);
        MAX = Math.max(MAX, getMaxValue(map));
    }

    private static void moveLeft(int[][] map, Queue<Integer> queue) {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (map[y][x] != 0) {
                    queue.add(map[y][x]);
                    map[y][x] = 0;
                }
            }

            int currentPtr = 0;
            int first = 0;
            int second = 0;
            while (queue.size() > 1) {
                first = queue.poll();
                second = queue.peek();

                if (first == second) {
                    queue.poll();
                    map[y][currentPtr] = first + second;
                    currentPtr++;
                }
                else {
                    map[y][currentPtr] = first;
                    currentPtr++;
                }
            }

            if (!queue.isEmpty()) {
                map[y][currentPtr] = queue.poll();
            }
        }

//        printMap(map, 1);
        MAX = Math.max(MAX, getMaxValue(map));
    }

    private static int getMaxValue(int[][] map) {
        int max = 0;
        for (int i = 0 ; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] > max) max = map[i][j];
            }
        }

        return max;
    }





//    private static void printMap(int[][] map, int moveWay) {
//        if (moveWay == 1) System.out.print("================왼쪽으로 이동===============\n");
//        if (moveWay == 2) System.out.print("================오른쪽으로 이동===============\n");
//        if (moveWay == 3) System.out.print("================위쪽으로 이동===============\n");
//        if (moveWay == 4) System.out.print("================아래쪽으로 이동===============\n");
//
//        for (int i = 0 ; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}


//        4
//        2 4 8 2
//        2 4 0 0
//        2 0 0 0
//        2 0 2 0