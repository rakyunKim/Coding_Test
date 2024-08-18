package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

/**
 * 모든 인덱스에 대해 for문을 돈다.
 * 현재 가리키고 있는 for문에서 +x축으로 가다 같은 숫자가 발견 되면 그 숫자를 기준으로 그 숫자와의 거리만큼 +y축의 값을 검사한다.
 * 그 값도 같다면 그 숫자와의 거리만큼 -x축에 있는 값을 검사한다.
 * 만약 4개의 값이 모두 같다면 answer에 크기를 저장한다.
 * 위 과정을 모든 원소에 대해 반복한다.
 * int[][]에 입력 값을 저장한다.
 */


public class Number1051 {
    static int[][] map;
    static int ySize;
    static int xSize;
    static int answer;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ySize = scanner.nextInt();
        xSize = scanner.nextInt();

        map = new int[ySize][xSize];

        for(int i = 0; i < ySize; i++){
            String temp = scanner.next();
            char[] cha = temp.toCharArray();
            for(int j = 0; j < cha.length; j++){
                map[i][j] = Integer.parseInt(String.valueOf(cha[j]));
            }
        }
        answer = 0;


//        for(int i = 0; i < ySize; i++){
//            for(int j = 0; j < xSize; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                dfs(i, j);
//                System.out.println("---------------------------------------------");
            }
        }

        if (answer == 0) {
            System.out.println(1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int currentY, int currentX) {
        int target = map[currentY][currentX];

//        System.out.println("현재 y좌표 :: " + currentY);
//        System.out.println("현재 x좌표 :: " + currentX);
//        System.out.println("현재 타겟 :: " + target);

        for(int i = currentX + 1; i < xSize; i++){
            if(map[currentY][i] == target){
//                System.out.println("x좌표 확인");
//                System.out.println(i);
                int length = i - currentX;
                if(currentY + length < ySize){
                    if(map[currentY + length][i] == target && map[currentY + length][currentX] == target){
                        if(answer < (length + 1) * (length + 1)){

//                            System.out.println("다음 x좌표 :: " + i);
//                            System.out.println("다음 y좌표 :: " + (currentY + length));
//                            System.out.println("맵 확인");
//                            System.out.println(map[currentY][currentX]);
//                            System.out.println(map[currentY][currentX + length]);
//                            System.out.println(map[currentY + length][currentX + length]);
//                            System.out.println(map[currentY + length][currentX]);

                            answer = (length + 1) * (length + 1);
                        }
                    }
                }
            }
        }
    }
}
