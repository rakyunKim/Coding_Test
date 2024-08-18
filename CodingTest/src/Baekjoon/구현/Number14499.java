package Baekjoon.구현;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Number14499 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);

        int maxY = scanner.nextInt();
        int maxX = scanner.nextInt();

        int[][] map = new int[maxY][maxX];

        int startY = scanner.nextInt();
        int startX = scanner.nextInt();

        int orderCount = scanner.nextInt();

        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        Map<String, Integer> diceIndex = new HashMap<>();
        diceIndex.put("top", 6);
        diceIndex.put("right", 3);
        diceIndex.put("left", 4);
        diceIndex.put("behind", 2);
        diceIndex.put("front", 5);
        diceIndex.put("bottom", 1);

        int[] dice = new int[7];

        for(int i = 0; i < orderCount; i++){
            int order = scanner.nextInt();

            if(order == 4 && startY + 1 < maxY){
                startY += 1;

                int behind = diceIndex.get("bottom");
                int bottom = diceIndex.get("front");
                int front = diceIndex.get("top");
                int top = diceIndex.get("behind");

                diceIndex.put("behind", behind);
                diceIndex.put("bottom", bottom);
                diceIndex.put("front", front);
                diceIndex.put("top", top);


                int next = map[startY][startX];

                if(next == 0){
                    map[startY][startX] = dice[diceIndex.get("bottom")];
                    System.out.println(dice[diceIndex.get("top")]);
                } else {
                    map[startY][startX] = 0;
                    dice[diceIndex.get("bottom")] = next;
                    System.out.println(dice[diceIndex.get("top")]);
                }
            }

            else if(order == 3 && startY - 1 >= 0){
                startY -= 1;

                int behind = diceIndex.get("top");
                int top = diceIndex.get("front");
                int front = diceIndex.get("bottom");
                int bottom = diceIndex.get("behind");

                diceIndex.put("behind", behind);
                diceIndex.put("bottom", bottom);
                diceIndex.put("front", front);
                diceIndex.put("top", top);


                int next = map[startY][startX];
                if(next == 0){
                    map[startY][startX] = dice[diceIndex.get("bottom")];
                    System.out.println(dice[diceIndex.get("top")]);
                } else {
                    map[startY][startX] = 0;
                    dice[diceIndex.get("bottom")] = next;
                    System.out.println(dice[diceIndex.get("top")]);
                }
            }

            if(order == 2 && startX - 1 >= 0){
                startX -= 1;

                int right = diceIndex.get("bottom");
                int top = diceIndex.get("right");
                int left = diceIndex.get("top");
                int bottom = diceIndex.get("left");

                diceIndex.put("right", right);
                diceIndex.put("bottom", bottom);
                diceIndex.put("left", left);
                diceIndex.put("top", top);

                int next = map[startY][startX];

                if(next == 0){
                    map[startY][startX] = dice[diceIndex.get("bottom")];
                    System.out.println(dice[diceIndex.get("top")]);
                } else {
                    map[startY][startX] = 0;
                    dice[diceIndex.get("bottom")] = next;
                    System.out.println(dice[diceIndex.get("top")]);
                }
            }

            if(order == 1 && startX + 1 < maxX){
                startX += 1;

                int left = diceIndex.get("bottom");
                int bottom = diceIndex.get("right");
                int right = diceIndex.get("top");
                int top = diceIndex.get("left");

                diceIndex.put("right", right);
                diceIndex.put("bottom", bottom);
                diceIndex.put("left", left);
                diceIndex.put("top", top);

                int next = map[startY][startX];
                if(next == 0){
                    map[startY][startX] = dice[diceIndex.get("bottom")];
                    System.out.println(dice[diceIndex.get("top")]);
                } else {
                    map[startY][startX] = 0;
                    dice[diceIndex.get("bottom")] = next;
                    System.out.println(dice[diceIndex.get("top")]);
                }
            }
        }
    }
}
