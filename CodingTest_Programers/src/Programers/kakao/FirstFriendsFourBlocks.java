package Programers.kakao;

import java.io.IOException;
import java.util.*;
public class FirstFriendsFourBlocks {
    static char[][] map;
    static int y;
    static int x;
    static int[][] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {

    }
    public int solution(int m, int n, String[] board) {
        // x + 1 오른쪽
        // y + 1 아래
        // x + 1 + y + 1 오른쪽 아래
        /*
        먼저 주어진 판 안에서 4개의 같은 문자가 있는지 확인한다.
        있다면 그 문자들의 좌표를 리스트에 저장한다.

        다음으로 리스트에 저장되어 있는 좌표를 0으로 바꾸면서
        만약 문자판이 이미 0이 아니라면 지워지는 블록을 표시하는 answer변수를 ++해준다.

        마지막으로 판의 위쪽에 위치해 있는 문자들을 아래로 내려준다.
        */

        map = new char[m][n];
        y = m;
        x = n;

        for(int i = 0; i < board.length; i++) {
            char[] temp = board[i].toCharArray();

            for(int j = 0; j < temp.length; j++) {
                map[i][j] = temp[j];
            }
        }

        // printMap();
        int answer = 0;
        while(checkDuplicate())
        {
            answer += deleteDuplicate();
            // printMap();
            dropBlocks();
            // printMap();
        }


        return answer;
    }

    private static void dropBlocks()
    {
        for(int px = 0; px < x; px++) {
            while(true) {
                boolean isChanged = false;
                int emptyY = -1;
                int emptyX = -1;

                for(int py = y - 1; py >= 0; py--) {
                    if(map[py][px] == '.') {
                        emptyY = py;
                        emptyX = px;
                        break;
                    }
                }

                if(emptyY > 0 && emptyX >= 0) {
                    for(int py = emptyY - 1; py >= 0; py--) {
                        if(map[py][px] != '.') {
                            isChanged = true;
                            map[emptyY][emptyX] = map[py][px];
                            map[py][px] = '.';
                            break;
                        }
                    }
                }

                if(!isChanged) break;
            }

        }
    }


    private static boolean checkDuplicate()
    {
        boolean isPossible = false;
        visited = new int[y][x];
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(map[i][j] != '.' &&
                        j < x - 1 && i < y - 1 &&
                        map[i][j] == map[i][j + 1] &&
                        map[i][j] == map[i + 1][j] &&
                        map[i][j] == map[i + 1][j + 1])
                {
                    isPossible = true;

                    if(visited[i][j] == 0) {
                        visited[i][j] = 1;
                    }

                    if(visited[i][j + 1] == 0) {
                        visited[i][j + 1] = 1;
                    }

                    if(visited[i + 1][j] == 0) {
                        visited[i + 1][j] = 1;
                    }

                    if(visited[i + 1][j + 1] == 0) {
                        visited[i + 1][j + 1] = 1;
                    }
                }
            }
        }

        return isPossible;
    }

    private static int deleteDuplicate()
    {
        int duplicateCount = 0;
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(visited[i][j] == 1) {
                    duplicateCount++;
                    map[i][j] = '.';
                }
            }
        }

        return duplicateCount;
    }

    private static void printMap()
    {
        System.out.println("==================");
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("==================");
    }
}
