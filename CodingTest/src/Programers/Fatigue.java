package Programers;

import java.io.IOException;

public class Fatigue {
    static int[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        int k = 80;
        int[][] dungeons = new int[][]{
                {80,20},
                {50,40},
                {30,10}
        };

        System.out.println(solution(k, dungeons));
    }
    public static int solution(int k, int[][] dungeons) {
        // 던전의 최대 개수는 8이다. 그러므로 가능한 모든 경우의 수를 돌면서
        // 최대 개수를 리턴하면 된다.
        // 방문 배열을 만들어 내가 방문했던 던전은 다시 방문하지 않도록 한다.

        max = 0;
        visited = new int[dungeons.length];
        for (int number = 0; number < dungeons.length; number++) {
            if (k >= dungeons[number][0]) {
                visited[number] = 1;
                checkMaxCountStartAt(k - dungeons[number][1], 1, dungeons);
                visited[number] = 0;
            }
        }

        return max;
    }

    private static void checkMaxCountStartAt(int currentFatigue, int currentCount, int[][] dungeonsInfo) {
        if (max < currentCount) max = currentCount;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0 && currentFatigue >= dungeonsInfo[i][0]) {
                visited[i] = 1;
                checkMaxCountStartAt(currentFatigue - dungeonsInfo[i][1], currentCount + 1, dungeonsInfo);
                visited[i] = 0;
            }
        }
    }
}
