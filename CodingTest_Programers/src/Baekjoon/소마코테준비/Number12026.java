//package Baekjoon.소마코테준비;
//import java.io.IOException;
//import java.util.*;
//
//public class Number12026 {
//    static int targetSize;
//    static int[] arr;
//    static int answer;
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//
//        targetSize = scanner.nextInt();
//        arr = new int[targetSize];
//
//        String boj = scanner.next();
//        char[] carr = new char[boj.length()];
//
//        for (int i = 0; i < boj.length(); i++) {
//            carr[i] = boj.charAt(i);
//            if(carr[i] == 'B') arr[i] = 1;
//            else if(carr[i] == 'O') arr[i] = 2;
//            else if(carr[i] == 'J') arr[i] = 3;
//        }
//
//        answer = 1000000000;
//
////        for(int i = 1; i < targetSize; i++){
////            if(arr[i] == 2){
////                recursive(i, 3, i * i);
////            }
////        }
//
//        recursive(0, 2, 0);
//
//        System.out.println(answer == 1000000000 ? -1 : answer);
//    }
//
//    private static void recursive(int idx, int target, int sum) {
//        if(idx == targetSize - 1 && answer > sum){
//            answer = sum;
//        }
//        for(int i = idx + 1; i < targetSize; i++){
//            if(arr[i] == target){
//                if(target == 1) recursive(i, 2, sum + ((i - idx) * (i - idx)));
//                if(target == 2) recursive(i, 3, sum + ((i - idx) * (i - idx)));
//                if(target == 3) recursive(i, 1, sum + ((i - idx) * (i - idx)));
//            }
//        }
//    }
//}
