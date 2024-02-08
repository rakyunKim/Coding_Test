package Baekjoon.소마코테준비;

import java.util.*;

public class Number9963Retry {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        List<Integer> checkX = new ArrayList<>();
        List<Integer> checkYMinusX = new ArrayList<>();
        List<Integer> checkYPlusX = new ArrayList<>();
        int[][] chessPlate = new int[target + 1][target + 1];

        int count = 0;
        boolean isPossible = false;
        for(int i = 1; i <= target; i++){
            for(int y = 1; y <= target; y++){
                isPossible = false;
                for(int x = i; x <= target; x++){
                    if(!checkX.contains(x) && !checkYMinusX.contains(y - x) && !checkYPlusX.contains(y + x)){
                        checkX.add(x);
                        checkYMinusX.add(y - x);
                        checkYPlusX.add(y + x);
                        isPossible = true;
                        break;
                    }
                }
                if(!isPossible){
                    break;
                }
                if(checkX.size() == target){
                    count ++;
                }
            }
        }
        System.out.println(count);

    }
}