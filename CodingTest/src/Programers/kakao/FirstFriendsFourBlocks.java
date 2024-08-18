package Programers.kakao;

import java.io.IOException;
public class FirstFriendsFourBlocks {
    static char[][] map;
    static int y;
    static int x;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int m = 4;
        int n = 5;
        String[] board = new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(solution(m, n, board));
    }
    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];
        y = m;
        x = n;

        for(int i = 0; i < board.length; i++) {
            char[] temp = board[i].toCharArray();

            for(int j = 0; j < temp.length; j++) {
                map[i][j] = temp[j];
            }
        }

        int answer = 0;
        while(true)
        {
            int deleted = deleteDuplicate();

            if (deleted == 0) break;
            answer += deleted;

            dropBlocks();
        }

        return answer;
    }

    private static int deleteDuplicate()
    {
        int deletedBlockCount = 0;

        int[][] shouldDelete = new int[y][x];

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(map[i][j] != '.' &&
                        j < x - 1 && i < y - 1 &&
                        map[i][j] == map[i][j + 1] &&
                        map[i][j] == map[i + 1][j] &&
                        map[i][j] == map[i + 1][j + 1])
                {
                    shouldDelete[i][j] = 1;
                    shouldDelete[i][j + 1] = 1;
                    shouldDelete[i + 1][j] = 1;
                    shouldDelete[i + 1][j + 1] = 1;
                }
            }
        }

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if (shouldDelete[i][j] == 1) {
                    map[i][j] = '.';
                    deletedBlockCount++;
                }
            }
        }

        return deletedBlockCount;
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

                if(emptyY > 0) {
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
