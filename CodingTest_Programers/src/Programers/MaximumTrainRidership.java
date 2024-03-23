package Programers;

import java.io.IOException;
import java.util.ArrayList;

public class MaximumTrainRidership {
    static ArrayList<Passenger>[] canMove;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        int n = 6;
        int[] passenger = new int[]{1,1,1,1,1,1};
        int[][] train = new int[][]{
                {1,2},
                {1,3},
                {1,4},
                {3,5},
                {3,6}
        };

        int[] result = solution(n, passenger, train);
    }

    private static int[] solution(int n, int[] passenger, int[][] train) {
        canMove = new ArrayList[n];
        for (ArrayList<Passenger> a : canMove){
            a = new ArrayList<>();
        }

        for (int i = 0; i < n; i ++){
            int start = train[i][0];
            int end = train[i][1];
            canMove[start].add(new Passenger(end, passenger[end - 1]));
            canMove[end].add(new Passenger(start, passenger[start - 1]));
        }

        dfs(1);


        int[] answer = new int[]{};
        return answer;
    }

    private static void dfs(int i) {

    }
}
class Passenger {
    int train;
    int passenger;
    public Passenger(int train, int passenger){
        this.train = train;
        this.passenger = passenger;
    }

}
