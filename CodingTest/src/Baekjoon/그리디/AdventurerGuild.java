package Baekjoon.그리디;

import java.io.IOException;
import java.util.*;

public class AdventurerGuild {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);

        int adventurerCount = scanner.nextInt();
        PriorityQueue<Integer> fear = new PriorityQueue<>();

        for(int i = 0; i < adventurerCount; i++){
            fear.add(scanner.nextInt());
        }

        int groupCount = 0;

        for(int i = 0; i < adventurerCount; i++){
            if(fear.isEmpty()) break;

            int popCount = fear.peek();
            int current = popCount;

            while (popCount > 0 && !fear.isEmpty()){
                int fearFactor = fear.poll();
                if(fearFactor > popCount){
                    break;
                }
                current--;
            }
            groupCount += current <= 0 ? 1 : 0;
        }

        System.out.println(groupCount);
    }
}
