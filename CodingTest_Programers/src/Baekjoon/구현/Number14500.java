package Baekjoon.구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number14500 {

    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visit;
    static int ySize;
    static int xSize;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        map = new int[ySize][xSize];

        for(int i = 0; i < ySize; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < xSize; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i = 0; i < ySize; i++){
//            for(int j = 0; j < xSize; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }

        int first = findFirst();

        int second = findSecond();
        System.out.println(second);
    }

    private static int findSecond() {
        int max = 0;

        for(int i = 0; i + 1 < ySize; i++){
            int sum = 0;
            for(int j = 0; j + 1 < xSize; j++){
                sum = map[i][j] + map[i][j  + 1]
                        + map[i + 1][j] + map[i + 1][j + 1];
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    private static int findFirst() {
        int max = 0;

        for(int i = 0; i < ySize; i++){
            int xPointer = 0;
            while(xPointer + 3 < xSize){
                int sum = map[i][xPointer] + map[i][xPointer + 1]
                        + map[i][xPointer + 2] + map[i][xPointer + 3];
                max = Math.max(sum, max);
                xPointer++;
            }
        }

        for(int i = 0; i < xSize; i++){
            int yPointer = 0;
            while(yPointer + 3 < ySize){
                int sum = map[yPointer][i] + map[yPointer + 1][i]
                        + map[yPointer + 2][i] + map[yPointer + 3][i];
                max = Math.max(sum, max);
                yPointer++;
            }
        }

        return max;
    }
}