package Programers;

import java.io.IOException;
import java.util.ArrayList;

public class MaximumTrainRidership {
    static ArrayList<Passenger>[] canMove;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws IOException {
//        int n = 6;
//        int n = 4;
        int n = 5;
//        int[] passenger = new int[]{1,1,1,1,1,1};
//        int[] passenger = new int[]{2,1,2,2};
        int[] passenger = new int[]{1,1,2,3,4};
//        int[][] train = new int[][]{
//                {1,2},
//                {1,3},
//                {1,4},
//                {3,5},
//                {3,6}
//        };
//        int[][] train = new int[][]{
//                {1,2},
//                {1,3},
//                {2,4}
//        };
        int[][] train = new int[][]{
                {1,2},
                {1,3},
                {1,4},
                {1,5}
        };

        int[] result = solution(n, passenger, train);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] solution(int n, int[] passenger, int[][] train) {
        visited = new boolean[n + 1];
        canMove = new ArrayList[n + 1];
        answer = new int[2];
        for (int i = 1; i <= n; i++){
            canMove[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i ++){
            int start = train[i][0];
            int end = train[i][1];
            canMove[start].add(new Passenger(end, passenger[end - 1]));
            canMove[end].add(new Passenger(start, passenger[start - 1]));
        }

        dfs(1, passenger[0]);

        return answer;
    }

    private static void dfs(int start, int total) {
        if (total >= answer[1] && start > answer[0]){
            answer[0] = start;
            answer[1] = total;
        }
        visited[start] = true;
        for (Passenger p : canMove[start]){
            int trainNum = p.train;
            int value = p.value;
            if (!visited[trainNum]){
                int nextTotal = total + value;
                dfs(trainNum, nextTotal);
            }
        }
    }
}
class Passenger {
    int train;
    int value;
    public Passenger(int train, int value){
        this.train = train;
        this.value = value;
    }

}
