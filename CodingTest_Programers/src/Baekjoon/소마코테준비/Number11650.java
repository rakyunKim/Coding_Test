package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number11650 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int pointCount = scanner.nextInt();
        int[][] point = new int[pointCount][2];

        for(int i = 0; i < pointCount; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            point[i][0] = x;
            point[i][1] = y;
        }

        Arrays.sort(point, (point1, point2) -> {
           if(point1[0] == point2[0]) return point1[1] - point2[1];
           else return point1[0] - point2[0];
        });

        for(int i = 0; i < pointCount; i++){
            System.out.println(point[i][0] + " " + point[i][1]);
        }
    }
}
