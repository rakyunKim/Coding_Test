package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class Number10815 {
    static int[] numberCard;
    static int numberCardCount;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        numberCardCount = scanner.nextInt();
        numberCard = new int[numberCardCount];
        for(int i = 0; i < numberCardCount; i++){
            numberCard[i] = scanner.nextInt();
        }
        Arrays.sort(numberCard);

        int haveCardCount = scanner.nextInt();
        int[] haveCard = new int[haveCardCount];
        for(int i = 0; i < haveCardCount; i++){
            haveCard[i] = scanner.nextInt();
        }

        int[] checkCard= new int[haveCardCount];
        for(int cardIndex = 0; cardIndex < haveCardCount; cardIndex++){
            if(binarySearch(haveCard[cardIndex])){
                checkCard[cardIndex] = 1;
            }
        }

        for(int i : checkCard){
            System.out.print(i + " ");
        }
    }

    private static boolean binarySearch(int cardValue) {
        int startIndex = 0;
        int endIndex = numberCardCount - 1;
        while(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if(cardValue == numberCard[midIndex]){
                return true;
            } else if(cardValue < numberCard[midIndex]){
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return false;
    }
}
