package Programers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SplittingPowerGridIntoTwo {
    static int answer = Integer.MAX_VALUE;
    static int[] visited;
    static ArrayList<Integer>[] adjacency;
    public static void main(String[] args) {
//        int n = 9;
//        int n = 4;
        int n = 7;

//        int[][] wires = new int[][]{
//                {1,3},
//                {2,3},
//                {3,4},
//                {4,5},
//                {4,6},
//                {4,7},
//                {7,8},
//                {7,9}
//        };

//        int[][] wires = new int[][]{
//                {1, 2},
//                {2, 3},
//                {3, 4}
//        };

        int[][] wires = new int[][]{
                {1,2},
                {2,7},
                {3,7},
                {3,4},
                {4,5},
                {6,7}
        };

        System.out.println(solution(n, wires));
    }
    public static int solution(int n, int[][] wires) {
        // 전선을 끊는 로직과 전선이 끊겼을 때 왼쪽 네트워크의 송전탑 개수, 오른쪽 네트워크의 송전탑 개수를 세는 함수가 필요함
        adjacency = new ArrayList[n + 1];

        for (int i = 0; i < adjacency.length; i++) {
            adjacency[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int element1 = wires[i][0];
            int element2 = wires[i][1];
            adjacency[element1].add(element2);
            adjacency[element2].add(element1);
        }

        for (int i = 0; i < wires.length; i++) {
            visited = new int[n + 1];
            int element1 = wires[i][0];
            int element2 = wires[i][1];
            for (int j = 0; j < adjacency[element1].size(); j++) {
                if(adjacency[element1].get(j) == element2) {
                    adjacency[element1].remove(j);
                    break;
                }
            }

            for (int j = 0; j < adjacency[element2].size(); j++) {
                if(adjacency[element2].get(j) == element1) {
                    adjacency[element2].remove(j);
                    break;
                }
            }

            int element1Count = countElectronicTopAt(element1);
            int element2Count = countElectronicTopAt(element2);
            int differenceCountInElectronicTop = Math.abs(element1Count - element2Count);

            adjacency[element1].add(element2);
            adjacency[element2].add(element1);

            if (answer > differenceCountInElectronicTop) answer = differenceCountInElectronicTop;
        }

        return answer;
    }

    private static int countElectronicTopAt(int element) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(element);
        int count = 1;
        visited[element] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : adjacency[current]) {
                if (visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}
