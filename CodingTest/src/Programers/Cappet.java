package Programers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Cappet {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] answer = solution(8, 1);

        System.out.println(answer[1] + " :: " + answer[0]);
    }

    static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        boolean isContinue = true;
        for (int i = brown / 2; i > 0; i--){
            if (isContinue){
                for(int j = i; j > 0; j--){
                    if(i * j == total){
                        if(((i * 2) + (j * 2) - 4)  == brown){
                            answer[0] = i;
                            answer[1] = j;
                            isContinue = false;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }

//    private static boolean checkColor(int y, int x, int brown, int yellow) {
//
//        int[][] map = new int[y][x];
//        for(int i = 0; i < x; i++){
//            map[0][i] = 1;
//            map[y - 1][i] = 1;
//        }
//
//        for(int i = 0; i < x; i++){
//            map[i][0] = 1;
//            map[i][x - 1] = 1;
//        }
//
//        int count = 0;
//        for(int i = 0; i < y; i ++){
//            for(int j = 0; j < x; j++){
//                if(map[i][j] == 1) count++;
//            }
//        }
//    }
}
