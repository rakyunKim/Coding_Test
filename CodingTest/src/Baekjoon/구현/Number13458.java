package Baekjoon.구현;

import java.io.IOException;
import java.util.*;

public class Number13458 {
    static int commander;
    static int subCommander;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int testRoomCount = scanner.nextInt();

        int[] room = new int[testRoomCount];
        for(int i = 0; i < testRoomCount; i++){
            room[i] = scanner.nextInt();
        }

        commander = scanner.nextInt();
        subCommander = scanner.nextInt();

        long totalSupervisor = testRoomCount;
        for(int i = 0; i < testRoomCount; i++){
            int studentCount = room[i];

            int remainingStudent = studentCount - commander;

            if(remainingStudent > 0){
                totalSupervisor += remainingStudent % subCommander == 0 ?
                        remainingStudent / subCommander :
                        (remainingStudent / subCommander) + 1;
            }
        }

        System.out.println(totalSupervisor);
    }
}
