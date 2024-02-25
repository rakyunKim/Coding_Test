package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number2309Retry {
    static int[] dwarfHeight;
    static final int TARGET = 100;
    static Stack<Integer> stack;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        dwarfHeight = new int[9];
        for(int i = 0; i < 9; i++){
            dwarfHeight[i] = scanner.nextInt();
        }
        stack = new Stack<>();
        visited = new int[9];
        Arrays.sort(dwarfHeight);

        find(0);

    }

    private static void find(int height) {
//        System.out.println("현재 키 :: " + height);
        if(stack.size() == 7){
            if(height == TARGET){
                Collections.sort(stack);
                for(int i : stack){
                    System.out.println(i);
                }
                System.out.println();
                System.exit(0);
            }
            return ;
        } else {
            for(int i = 0; i < 9; i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    stack.add(dwarfHeight[i]);
                    height += dwarfHeight[i];
                    find(height);
                    height -= dwarfHeight[i];
                    stack.pop();
                    visited[i] = 0;

                }
            }
            for(int i = 0; i < 9; i++){
                if(visited[i] == 0){
                    visited[i] = 1;
                    find(height);
                    visited[i] = 0;
                }
            }
        }
    }


//    private static boolean find(int height) {
////        System.out.println("현재 키 :: " + height);
//        if(stack.size() == 7){
//            if(height == TARGET){
//                Collections.sort(stack);
//                for(int i : stack){
//                    System.out.println(i);
//                }
//                System.out.println();
//                return true;
//            }
//            return false;
//        } else {
//            for(int i = 0; i < 9; i++){
//                if(visited[i] == 0){
//                    visited[i] = 1;
//                    stack.add(dwarfHeight[i]);
//                    height += dwarfHeight[i];
//                    if(find(height)){
//                        return true;
//                    } else {
//                        height -= dwarfHeight[i];
//                        stack.pop();
//                        visited[i] = 0;
//                    }
//                }
//            }
//            for(int i = 0; i < 9; i++){
//                if(visited[i] == 0){
//                    visited[i] = 1;
//                    if(find(height)){
//                        return true;
//                    } else {
//                        visited[i] = 0;
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
