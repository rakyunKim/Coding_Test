package Baekjoon.소마코테준비;
import java.util.*;

public class Number11651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pointCount = scanner.nextInt();
        int[][] point = new int[pointCount][2];

        for(int i = 0; i < pointCount; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            point[i][0] = x;
            point[i][1] = y;
        }

        Arrays.sort(point, (e1, e2) ->
            (e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1])
        );

        for(int i = 0; i < pointCount; i++){
            System.out.println(point[i][0] + " " + point[i][1]);
        }
    }
}
