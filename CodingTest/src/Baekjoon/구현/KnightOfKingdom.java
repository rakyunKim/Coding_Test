package Baekjoon.구현;

import java.io.IOException;
import java.util.Scanner;

public class KnightOfKingdom {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[9][9];

        String startPoint = scanner.next();
        char[] temp = startPoint.toCharArray();

        int x = temp[0] == 'a' ? 1 :
                temp[0] == 'b' ? 2 :
                temp[0] == 'c' ? 3 :
                        temp[0] == 'd' ? 4 :
                                temp[0] == 'e' ? 5 :
                                        temp[0] == 'f' ? 6 :
                                                temp[0] == 'g' ? 7 :
                temp[0] == 'h' ? 8 : 0;

        int y = Integer.parseInt(String.valueOf(temp[1]));

        int count = 0;

        if(y - 2 > 0 && x + 1 < 9){
            count++;
        }

        if(y - 1 > 0 && x + 2 < 9){
            count++;
        }

        if(y + 1 < 9 && x + 2 < 9){
            count++;
        }

        if(y + 2 < 9 && x + 1 < 9){
            count++;
        }

        if(y + 2 < 9 && x - 1 > 0){
            count++;
        }

        if(y + 1 < 9 && x - 2 > 0){
            count++;
        }

        if(y - 1 > 0 && x - 2 > 0){
            count++;
        }

        if(y - 2 > 0 && x - 1 > 0){
            count++;
        }

        System.out.println(count);
    }
}
