package Programers;

import java.io.IOException;
import java.util.Arrays;

public class DistributingGiftCards {
    public static void main(String[] args) throws IOException {
//        int[] gift_cards = new int[]{4,5,3,2,1};
        int[] gift_cards = new int[]{6, 6, 4, 22, 40, 16, 24, 19, 14, 18, 5, 16, 1, 39, 40, 15, 13, 17, 8, 23, 33, 15, 19, 23, 27, 18, 11, 31, 32, 39, 14, 32, 8, 22, 38, 36, 4, 30, 8, 17};
//        int[] wants = new int[]{2,4,4,5,1};
        int[] wants = new int[]{32, 3, 33, 18, 37, 32, 7, 32, 12, 15, 38, 2, 18, 30, 21, 35, 31, 6, 36, 26, 14, 21, 27, 9, 29, 40, 36, 2, 29, 15, 16, 29, 14, 9, 32, 31, 11, 39, 23, 8};
        int result = solution(gift_cards, wants);

        System.out.println(result);
    }

    private static int solution(int[] giftCards, int[] wants) {
        Arrays.sort(giftCards);
        Arrays.sort(wants);

        int arrLength = giftCards.length;
        int answer = 0;
        for (int wantIndex = 0; wantIndex < arrLength; wantIndex++){
            for (int giftIndex = 0; giftIndex < arrLength; giftIndex++){
                if (wants[wantIndex] > giftCards[giftCards.length - 1]){
                    answer++;
                    break;
                }
                if (wants[wantIndex] == giftCards[giftIndex]){
                    giftCards[giftIndex] = 0;
                    break;
                } else if (wants[wantIndex] < giftCards[giftIndex]){
                    answer++;
                    break;
                }
            }
        }


        return answer;
    }
}
