package Programers.kakao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    static int target = 0;
    static int maxRound = 0;

    //    public int solution(int coin, int[] cards) {
    public int solution(int coin, int[] cards) {
        int currentCardsIdx;
        List<Integer> currentDeck = new ArrayList<>();
        int startCardLength = cards.length / 3;

        for (currentCardsIdx = 0;
             currentCardsIdx < startCardLength;
             currentCardsIdx++) {
            currentDeck.add(cards[currentCardsIdx]);
        }

        // 오름차순으로 정렬 binarySearch에 유리하게
        currentDeck.sort(Comparator.reverseOrder());

        // 1번 카드를 받는 경우
        currentDeck.add(cards[currentCardsIdx]);
        playGame(new Input(coin - 1, cards, currentCardsIdx + 2, 1, currentDeck));
        currentDeck.remove(currentCardsIdx);

        // 2번 카드를 받는 경우
        currentDeck.add(cards[currentCardsIdx + 1]);
        playGame(new Input(coin - 1, cards, currentCardsIdx + 2, 1, currentDeck));
        currentDeck.remove(currentCardsIdx);

        // 카드를 모두 받는 경우
        currentDeck.add(cards[currentCardsIdx + 1]);
        currentDeck.add(cards[currentCardsIdx]);
        playGame(new Input(coin - 2, cards, currentCardsIdx + 2, 1, currentDeck));
        currentDeck.remove(currentCardsIdx);
        currentDeck.remove(currentCardsIdx);

        // 카드를 모두 받지 않는 경우
        playGame(new Input(coin, cards, currentCardsIdx + 2, 1, currentDeck));

        return maxRound;
    }

    public void playGame(Input input) {
     


        if (!isPossible(0, input.currentDeck.size() - 1, input.currentDeck)) {
            if (maxRound < input.currentRound) {
                maxRound = input.currentRound;
            }
            return;
        }
        input.currentRound++;

        if (input.currentCardsIdx >= input.cards.length) {
            return ;
        }

        if (input.coin > 0) {

            // 1번 카드를 받는 경우
            input.currentDeck.add(input.cards[input.currentCardsIdx]);
            playGame(
                    new Input(input.coin - 1, input.cards, input.currentCardsIdx + 2, input.currentRound, input.currentDeck));
            input.currentDeck.remove(input.currentCardsIdx);


            // 2번 카드를 받는 경우
            input.currentDeck.add(input.cards[input.currentCardsIdx + 1]);
            playGame(
                    new Input(input.coin - 1, input.cards, input.currentCardsIdx + 2, input.currentRound, input.currentDeck));
            input.currentDeck.remove(input.currentCardsIdx);



            if (input.coin > 1) {
                // 카드를 모두 받는 경우
                input.currentDeck.add(input.cards[input.currentCardsIdx]);
                input.currentDeck.add(input.cards[input.currentCardsIdx + 1]);

                playGame(
                        new Input(input.coin - 2, input.cards, input.currentCardsIdx + 2, input.currentRound, input.currentDeck));
                input.currentDeck.remove(input.currentCardsIdx);
                input.currentDeck.remove(input.currentCardsIdx);
            }
        }

        // 카드를 모두 받지 않는 경우
        playGame(new Input(input.coin, input.cards, input.currentCardsIdx + 2, input.currentRound, input.currentDeck));

    }

    public boolean isPossible(int firstIdx, int secondIdx, List<Integer> currentDeck) {
        if (firstIdx == secondIdx)
            return false;

        if (currentDeck.get(firstIdx) + currentDeck.get(secondIdx) == target) {
            currentDeck.remove(firstIdx);
            currentDeck.remove(secondIdx);
            return true;
        }
        if (currentDeck.get(firstIdx) + currentDeck.get(secondIdx) < target) {
            secondIdx--;
        }
        if (currentDeck.get(firstIdx) + currentDeck.get(secondIdx) > target) {
            firstIdx++;
            secondIdx = currentDeck.size() - 1;
        }

        return isPossible(firstIdx, secondIdx, currentDeck);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        int result = solution.solution(4, cards);
        System.out.println("Maximum rounds: " + result); // Expected output: Maximum rounds: 3
    }
}


class Input {
    int coin;
    int[] cards;
    int currentCardsIdx;
    int currentRound;
    List<Integer> currentDeck;

    public Input(int coin, int[] cards, int currentCardsIdx, int currentRound, List<Integer> currentDeck) {
        this.coin = coin;
        this.cards = cards;
        this.currentCardsIdx = currentCardsIdx;
        this.currentRound = currentRound;
        this.currentDeck = currentDeck;
    }
}