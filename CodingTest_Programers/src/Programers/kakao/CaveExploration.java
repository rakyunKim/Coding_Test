package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class CaveExploration {
    static int[] haveToVisited;
    static int[] haveToCheck;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        int n = 9; // 방 개수

        int[][] path = new int[][]{
                {0,1},
                {0,3},
                {0,7},
                {8,1},
                {3,6},
                {1,2},
                {4,7},
                {7,5}
        }; // 통로
//        int[][] path = new int[][]{
//                {8,1},
//                {0,1},
//                {1,2},
//                {0,7},
//                {4,7},
//                {0,3},
//                {7,5},
//                {3,6}
//        };

        int[][] order = new int[][]{
                {8,5},
                {6,7},
                {4,1}
        }; // 방문 순서
//        int[][] order = new int[][]{
//                {4,1},
//                {5,2}
//        };
//        int[][] order = new int[][]{
//                {4,1},
//                {8,7},
//                {6,5}
//        };

        System.out.println(solution(n, path, order));
    }
    public static boolean solution(int n, int[][] path, int[][] order) {
        init(order);
        Arrays.sort(path, (a, b) -> a[0] - b[0]);

        // 유니온 파인드를 해서 parent 배열이 모두 값이 0이 된다면, 모두 연결 되는 것이기 때문에 그럼 true를 리턴
        // 근데 유니온 파인드를 어떻게 해야 order와 path에 있는 값들을 적절히 parent 배열에 넣을 수 있을까
        // 5를 가기 위해선 7이 필요하고 7을 가기 위해선 6이 필요하고 6을 가기 위해선 3이 필요하다
        // 이런 정보들을 어떻게 자료구조에 담을 수 있을까


        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < path.length; i++) {
            int element1 = path[i][0];
            int element2 = path[i][1];
            union(element1, element2);
        }






        boolean answer = true;
        return answer;
    }

    private static void union(int element1, int element2) {
        int parent1 = find(element1);
        int parent2 = find(element2);

        if (parent1 == 0 || parent2 == 0) {
            parent[element1] = 0;
            parent[element2] = 0;
        } else {

        }
    }

    private static int find(int element) {
        if (parent[element] == element) {
            return element;
        } else {
            return parent[element] = find(parent[element]);
        }
    }

    private static void init(int[][] order) {
        // 어떤 원소를 방문하기 전에 방문해야 하는 원소
        haveToVisited = new int[order.length];

        // 조건을 가지고 있는 원소
        haveToCheck = new int[order.length];

        for (int i = 0; i < order.length; i++) {
            haveToVisited[i] = order[i][0];
        }

        for (int i = 0; i < order.length; i++) {
            haveToCheck[i] = order[i][1];
        }
    }
}
