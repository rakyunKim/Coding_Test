package Programers.kakao;

import java.io.IOException;

public class PressingKeypad {
    static int[] useLeft = new int[]{1,4,7};
    static int[] useRight = new int[]{3,6,9};
    static int[][] keypad = {
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {-1,0,-2},
    };
    static int[] currentLeftHand = new int[]{3, 0};
    static int[] currentRightHand = new int[]{3, 2};
    public static void main(String[] args) throws IOException {
//        int[] numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand = "right";
//        String hand = "left";

        String result = solution(numbers, hand);
        System.out.println(result);
    }

    private static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        for (int current : numbers) {
            if (canUseLeft(current)) {
                answer.append("L");
                currentLeftHand = pointOf(current);
            } else if (canUseRight(current)) {
                answer.append("R");
                currentRightHand = pointOf(current);
            } else {
                int checkLeftDistance = distanceOf(currentLeftHand, current);
                int checkRightDistance = distanceOf(currentRightHand, current);
                if (checkLeftDistance == checkRightDistance) {
                    if (hand.equals("left")) {
                        answer.append("L");
                        currentLeftHand = pointOf(current);
                    } else {
                        answer.append("R");
                        currentRightHand = pointOf(current);
                    }
                } else if (checkLeftDistance < checkRightDistance) {
                    answer.append("L");
                    currentLeftHand = pointOf(current);
                } else {
                    answer.append("R");
                    currentRightHand = pointOf(current);
                }
            }
        }




        return answer.toString();
    }

    private static boolean canUseLeft(int num){
        for (int i : useLeft) {
            if (i == num){
                return true;
            }
        }
        return false;
    }

    private static boolean canUseRight(int num){
        for (int i : useRight) {
            if (i == num){
                return true;
            }
        }
        return false;
    }

    private static int[] pointOf(int current) {
        int[] point = new int[2];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] == current) {
                    point[0] = i;
                    point[1] = j;
                    break;
                }
            }
        }
        return point;
    }

    private static int distanceOf(int[] currentHandPoint, int current) {
        int[] numberPoint = pointOf(current);
        int yDistance = Math.abs(currentHandPoint[0] - numberPoint[0]);
        int xDistance = Math.abs(currentHandPoint[1] - numberPoint[1]);

        return yDistance + xDistance;
    }
}
