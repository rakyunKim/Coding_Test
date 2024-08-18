package Baekjoon.소마코테준비;

import java.util.*;
import java.io.IOException;

/**
 * 현재 보고 있는 프린트의 중요도가 맥스 값과 같다면 answer 배열에 넣음 가장 앞쪽에
 * 그리고 맥스 값 수정
 * 아니면 다음 인덱스로 넘어감
 * 그렇게 계속 돌다가 주어진 타겟 인덱스와 같은 인덱스가 remove 될 때 Break 하고 count 출력
 */


public class Number1966 {
    static int MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int test = 0; test < testCase; test++){
            int printCount = scanner.nextInt();
            int targetIndex = scanner.nextInt();

            MAX_VALUE = Integer.MAX_VALUE;
            Queue<int[]> queue = new LinkedList<>();

            for(int i = 0; i < printCount; i++){
                int priority = scanner.nextInt();
                int[] forQueue = new int[2];
                forQueue[0] = i;
                forQueue[1] = priority;
                queue.add(forQueue);
            }

            int max = findMax(queue);

            int rankPointer = 0;
            while(!queue.isEmpty()){
                int[] current = queue.poll();

                if(current[1] == max){
                    rankPointer += 1;
                    if(current[0] == targetIndex){
                        System.out.println(rankPointer);
                        break;
                    }
                    max = findMax(queue);
                } else {
                    queue.add(current);
                }
            }
        }
    }

    private static int findMax(Queue<int[]> queue) {
        int max = 0;
        for(int[] i : queue){
            if(i[1] > max){
                max = i[1];
            }
        }
        return max;
    }
}
