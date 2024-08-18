package Programers.kakao;

import java.io.IOException;
import java.util.Stack;

public class ClawCraneGame {

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = new int[]{1,5,3,5,1,2,1,4};
        int result = solution(board, moves);
        System.out.println(result);
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        for (int currentMove  : moves) {
            int dollNum = pickDoll(board, currentMove - 1);
            if (dollNum != 0){
                if (addToStack(dollNum)){
                    answer += 2;
                }
            }
        }

        return answer;
    }

    private static boolean addToStack(int dollNum) {
        if (stack.isEmpty()){
            stack.add(dollNum);
            return false;
        } else{
            int prevDollNum = stack.peek();
            if (prevDollNum == dollNum){
                stack.pop();
                return true;
            } else {
                stack.add(dollNum);
                return false;
            }
        }
    }

    private static int pickDoll(int[][] board, int move) {
        int dollNum = 0;

        for (int i = 0; i < board.length; i++){
            if (board[i][move] != 0){
                dollNum = board[i][move];
                board[i][move] = 0;
                return dollNum;
            }
        }
        return dollNum;
    }
}
