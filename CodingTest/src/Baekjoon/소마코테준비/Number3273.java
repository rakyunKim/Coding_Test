package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number3273 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int arrLength = scanner.nextInt();
        int[] arr = new int[arrLength];
        for(int i = 0; i < arrLength; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int target = scanner.nextInt();
        int count = 0;

        for(int i = 0; i < arrLength; i++){
            if(arr[i] * 2 >= target){
                break;
            }
            if(arr[i] < target){
                int find = target - arr[i];
                for(int j = arrLength - 1; j >=0; j--){
                    if(arr[j] < find){
                        break;
                    }
                    else if(arr[j] == find){
                        count += 1;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
