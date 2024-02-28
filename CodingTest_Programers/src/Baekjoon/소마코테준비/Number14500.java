package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number14500 {
    static int ySize;
    static int xSize;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ySize = scanner.nextInt();
        xSize = scanner.nextInt();
        map = new int[ySize][xSize];

        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                map[i][j] = scanner.nextInt();
            }
        }
//        print();


    }
    private static void print(){
        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int findNumberOne(){
        int sum = 0;
        int[] square = new int[4];
        for(int j = 0; j < 4; j++){
            square[j] = map[0][j];
            sum += square[j];
        }

        for(int i = 0; i < ySize; i++){

        }
    }
    private static int findNumberTwo(){

    }
    private static int findNumberThree(){

    }
    private static int findNumberFour(){

    }
    private static int findNumberFive(){

    }
}
