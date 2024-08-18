package Programers;

import java.io.IOException;

public class FindBiggestSquare {
    public static void main(String[] args) throws IOException {
        int[][] board = new int[2][4];
//        board[0][0] = 0;
//        board[0][1] = 1;
//        board[0][2] = 1;
//        board[0][3] = 1;
//        board[1][0] = 1;
//        board[1][1] = 1;
//        board[1][2] = 1;
//        board[1][3] = 1;
//        board[2][0] = 1;
//        board[2][1] = 1;
//        board[2][2] = 1;
//        board[2][3] = 1;
//        board[3][0] = 0;
//        board[3][1] = 0;
//        board[3][2] = 1;
//        board[3][3] = 0;
//        for (int i = 0; i < board.length; i++){
//            for (int j = 0; j < board.length; j++){
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }

        board[0][0] = 0;
        board[0][1] = 0;
        board[0][2] = 0;
        board[0][3] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[1][3] = 0;
        System.out.println(solution(board));
    }

    private static int solution(int[][] board){
        int[][] dp = new int[board.length][board[0].length];
        int answer = 0;
        if (board.length == 1 && board[0].length == 1){
            if (board[0][0] == 0) return 0;
            else return 1;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == 1){
                    if (i < 1 || j < 1){
                        dp[i][j] = board[i][j];
                    }
                    else {
                        int diagonal = dp[i - 1][j - 1];
                        int over = dp[i - 1][j];
                        int left = dp[i][j - 1];
                        dp[i][j] = Math.min(Math.min(diagonal, over), left) + 1;
                        if (dp[i][j] > answer){
                            answer = dp[i][j];
                        }
                    }
                }
            }
        }
        return answer * answer;
    }
}
