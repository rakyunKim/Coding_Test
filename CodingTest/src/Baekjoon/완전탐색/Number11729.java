package Baekjoon.완전탐색;

import java.util.Scanner;
import java.util.*;

public class Number11729 {
    static int min;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int plateCount = scanner.nextInt();
        min = Integer.MAX_VALUE;
        Stack<Integer>[] plate = new Stack[3];
        plate[0] = new Stack<>();
        plate[1] = new Stack<>();
        plate[2] = new Stack<>();
        for (int i = plateCount; i > 0; i--)
        {
            plate[0].push(i);
        }
        System.out.println("Plates int stack : " + plate[0]);
        backTrack(plate, plateCount, 0);
        System.out.println("result :: " + min);

//        이전 풀이
//        int plate_count;
//        Stack<Integer>[] space = new Stack[3];
//        plate_count = scanner.nextInt();
//        min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < 3; i++) {
//            space[i] = new Stack<>();
//        }
//        for (int i = plate_count; i > 0; i--) {
//            space[0].add(i);
//        }
//        brute_force(0, space, 0);
//        System.out.println(min);
    }

    public static void backTrack(Stack<Integer>[] plate, int plateCount, int moveCount)
    {
        if (plate[2].size() == plateCount)
        {
            min = Math.min(min, moveCount);
            return ;
        }
        for (int i = 0; i < 3; i++)
        {
            if (!plate[i].isEmpty())
            {
                int currentNum = plate[i].pop();
                for (int j = 0; j < 3; j++)
                {
                    if (i != j)
                    {
                        if (plate[j].peek() > currentNum)
                        {
                            plate[j].push(currentNum);
                            backTrack(plate, plate[2].size(), moveCount + 1);
                            plate[j].pop();
                        }
                    }
                }
                plate[i].push(currentNum);
            }
        }
    }
    // 이전 풀이
//    public static void brute_force(int currentIdx, Stack<Integer>[] space, int total) {
//        if (checkSpace(space) && total < min) min = total;
//
//        int currentNumber = space[currentIdx].pop();
//
//        for (int i = 0; i < 3; i++) {
//            if (i != currentIdx && (space[i].isEmpty() || space[i].peek() > currentNumber)) {
//                space[i].push(currentNumber);
//                brute_force(i, space, total + 1);
//                space[i].pop();
//            }
//        }
//    }
//    private static boolean checkSpace(Stack<Integer>[] space) {
//        return space[0].isEmpty() && space[1].isEmpty();
//    }
}
