package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/*
    1. 받는 입력을 시간 당 얼마인지 계산 후에 배열에 저장
    2. 최소 시간과 최대 시간을 계산해서 몇시부터 몇시까지 주차했는지 확인
    3. 최소 시간부터 for문으로 탐색하며 다음 시간까지 총 몇 대의 차가 주차되어 있었는지 확인 후에
    주차 비용에 추가
 */



public class Number2979 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int one = scanner.nextInt();
        int two = scanner.nextInt() * 2;
        int three = scanner.nextInt() * 3;

        int[] firstCar = new int[2];
        int[] secondCar = new int[2];
        int[] thirdCar = new int[2];


        firstCar[0] = scanner.nextInt();
        firstCar[1] = scanner.nextInt();
        secondCar[0] = scanner.nextInt();
        secondCar[1] = scanner.nextInt();
        thirdCar[0] = scanner.nextInt();
        thirdCar[1] = scanner.nextInt();

        int minTime = Math.min(Math.min(firstCar[0], secondCar[0]), thirdCar[0]);
        int maxTime = Math.max(Math.max(firstCar[1], secondCar[1]), thirdCar[1]);

        int totalCost = 0;
        for(int i = minTime; i < maxTime; i++){
            int count = 0;
            int j = i + 1;
//            System.out.println("시작 시간 :: " + i + " 끝 시간 :: " + j);
            if(i >= firstCar[0] && j <= firstCar[1]){
//                System.out.println("첫번째 차 범위 가능");
                count++;
            }
            if(i >= secondCar[0] && j <= secondCar[1]){
//                System.out.println("두번째 차 범위 가능");
                count++;
            }
            if(i >= thirdCar[0] && j <= thirdCar[1]){
//                System.out.println("세번째 차 범위 가능");
                count++;
            }
            totalCost += count == 1 ? one : count == 2 ? two : count == 3 ? three : 0;
//            System.out.println("전체 비용 :: " + totalCost);
//            System.out.println("-----------------------------------");
        }

        System.out.println(totalCost);
    }
}
