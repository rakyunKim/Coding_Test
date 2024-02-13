package Baekjoon.소마코테준비;
import java.util.*;
public class Number2217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ropeCount = scanner.nextInt();
        Integer[] ropeWeight = new Integer[ropeCount];
        for(int i = 0; i < ropeCount; i++){
            ropeWeight[i] = scanner.nextInt();
        }

        Arrays.sort(ropeWeight, Collections.reverseOrder());
        int[] maxWeight = new int[ropeCount];
        for(int i = 0; i < ropeCount; i++){
            int min = 0;
            int count = 0;
            min = ropeWeight[i];
            count ++;
            for(int j = i - 1; j >= 0; j--){
                count ++;
            }
            maxWeight[i] = min * count;
        }

        int maxValue = 0;
        for(int i = 0; i < ropeCount; i++){
            if(maxWeight[i] > maxValue) maxValue = maxWeight[i];
        }
        System.out.println(maxValue);
    }
}
