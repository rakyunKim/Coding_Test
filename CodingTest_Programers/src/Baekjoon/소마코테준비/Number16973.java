package Baekjoon.소마코테준비;
import java.io.*;
import java.util.*;
public class Number16973 {
    static int[][]  visited;
    static int[] endPoint;
    static int[][] map;
    static int rectangleYSize;
    static int rectangleXSize;
    static int mapYSize;
    static int mapXSize;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        mapYSize = Integer.parseInt(token.nextToken());
        mapXSize = Integer.parseInt(token.nextToken());
        visited = new int[mapYSize + 1][mapXSize + 1];

        for(int i = 1; i <= mapYSize; i++){
            for(int j = 1; j <= mapXSize; j++){
                visited[i][j] = -1;
            }
        }

        map = new int[mapYSize + 1][mapXSize + 1];

        for(int i = 1; i <= mapYSize; i++){
            token = new StringTokenizer(buffer.readLine());
            for(int j = 1; j <= mapXSize; j++){
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(buffer.readLine());
        rectangleYSize = Integer.parseInt(token.nextToken());
        rectangleXSize = Integer.parseInt(token.nextToken());
        int[] startPoint = new int[2];
        for(int i = 0; i < 2; i++){
            startPoint[i] = Integer.parseInt(token.nextToken());
        }
        endPoint = new int[2];
        for(int i = 0; i < 2; i++){
            endPoint[i] = Integer.parseInt(token.nextToken());
        }
        bfs(startPoint[0], startPoint[1]);

        System.out.println(visited[endPoint[0]][endPoint[1]]);



//        for(int i = 1; i <= mapYSize; i++){
//            for(int j = 1; j <= mapXSize; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = 0;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            y = point[0];
            x = point[1];
            if(checkOver(y, x) && visited[y - 1][x] == -1){
                queue.add(new int[]{y - 1, x});
                visited[y - 1][x] = visited[y][x] + 1;
            }
            if(checkUnder(y, x) && visited[y + 1][x] == -1){
                queue.add(new int[]{y + 1, x});
                visited[y + 1][x] = visited[y][x] + 1;
            }
            if(checkRight(y, x) && visited[y][x + 1] == -1){
                queue.add(new int[]{y, x + 1});
                visited[y][x + 1] = visited[y][x] + 1;
            }
            if(checkLeft(y, x) && visited[y][x - 1] == -1){
                queue.add(new int[]{y, x - 1});
                visited[y][x - 1] = visited[y][x] + 1;
            }
        }
    }

    private static boolean checkRight(int y, int x){
        // 사각형의 오른쪽 = y좌표(y부터 y + ySize), x좌표(x + XSize)
        if(x + rectangleXSize > mapXSize){
            return false;
        }
        for(int i = y; i < y + rectangleYSize; i++){
            if(map[i][x + rectangleXSize] == 1){
                return false;
            }
        }
        return true;
    }
    private static boolean checkLeft(int y, int x){
        // 사각형의 왼쪽 = y좌표(y부터 y + ySize), x좌표(x - 1)
        if(x - 1 < 1){
            return false;
        }
        for(int i = y; i < y + rectangleYSize; i++){
            if(map[i][x - 1] == 1){
                return false;
            }
        }
        return true;
    }
    private static boolean checkOver(int y, int x){
        // 사각형의 위 = y좌표(-1), x좌표(x부터 xSize)
        if(y - 1 < 1){
            return false;
        }
        for(int i = x; i < x + rectangleXSize; i++){
            if(map[y - 1][i] == 1){
                return false;
            }
        }
        return true;
    }
    private static boolean checkUnder(int y, int x){
        // 사각형의 아래 = y좌표(+1), x좌표(1부터 xSize)
        if(y + rectangleYSize > mapYSize){
            return false;
        }
        for(int i = x; i < x + rectangleXSize; i++){
            if(map[y + rectangleYSize][i] == 1){
                return false;
            }
        }
        return true;
    }
}
