package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class NPlus1CardGame {
    static int target;
    static List<Integer> myCard = new ArrayList<>();
    static int answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int coin = 4;
        int[] cards = new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};

        System.out.println(solution(coin, cards));
    }

    public static int solution(int coin, int[] cards) {
        // 완전탐색을 적용해야 할 거 같다.
        // cards에서 두 장의 카드를 받을 때
        // 1. 모두 받지 않는 경우
        // 2. 한 장만 받는 경우
        // 3. 두 장 다 받는 경우로 완전탐색을 돌린다.
        // 그리고 내가 가지고 있는 카드 더미 안에서 두 장의 카드를 골라
        // target을 만드는 함수도 필요하다.

        target = cards.length + 1;

        for(int i = 0; i < 4; i++) {
            myCard.add(cards[i]);
            cards[i] = 0;
        }

        // 그런데 1000개의 cards[] 더미 안에서 3가지의 경우로 완전탐색을 실행하면
        // 3^1000인데 흠.. 이게 될까

        answer = 0;

        bruteForce(cards, coin, 4, 0);


        return answer;
    }

    private static void bruteForce(int[] cards, int coin, int nextCardIdx, int roundCount) {
        if(answer < roundCount) answer = roundCount;
        if(nextCardIdx >= cards.length) return;

//        System.out.println("======== 코인 현황 : " + coin + " ==========");
//        System.out.println("========= 내 카드 현황 =========");
//        for(int a : myCard) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        int deleted1 = cards[nextCardIdx];
        int deleted2 = cards[nextCardIdx + 1];

        cards[nextCardIdx] = 0;
        cards[nextCardIdx + 1] = 0;



        // 2장 다 받지 않을 경우
        for(int i = 0; i < myCard.size(); i++) {
            for(int j = i + 1; j < myCard.size(); j++) {
                if(myCard.get(i) + myCard.get(j) == target) {
                    int usedCard1 = myCard.get(i);
                    int usedCard2 = myCard.get(j);

                    myCard.remove(j);
                    myCard.remove(i);

                    bruteForce(cards, coin, nextCardIdx + 2, roundCount + 1);

                    myCard.add(usedCard1);
                    myCard.add(usedCard2);
                }
            }
        }

        if(coin == 0) return;

        // 코인 1개 쓰는 경우
        if(coin >= 1) {
            // deleted1 쓰는 경우
            myCard.add(deleted1);
            for(int i = 0; i < myCard.size(); i++) {
                for(int j = i + 1; j < myCard.size(); j++) {
                    if(myCard.get(i) + myCard.get(j) == target) {
                        int usedCard1 = myCard.get(i);
                        int usedCard2 = myCard.get(j);

                        myCard.remove(j);
                        myCard.remove(i);

                        bruteForce(cards, coin - 1, nextCardIdx + 2, roundCount + 1);

                        myCard.add(usedCard1);
                        myCard.add(usedCard2);
                    }
                }
            }

            for(int i = 0; i < myCard.size(); i++) {
                if(myCard.get(i) == deleted1) myCard.remove(i);
            }

            // deleted2 쓰는 경우
            myCard.add(deleted2);
            for(int i = 0; i < myCard.size(); i++) {
                for(int j = i + 1; j < myCard.size(); j++) {
                    if(myCard.get(i) + myCard.get(j) == target) {
                        int usedCard1 = myCard.get(i);
                        int usedCard2 = myCard.get(j);

                        myCard.remove(j);
                        myCard.remove(i);

                        bruteForce(cards, coin - 1, nextCardIdx + 2, roundCount + 1);

                        myCard.add(usedCard1);
                        myCard.add(usedCard2);
                    }
                }
            }

            for(int i = 0; i < myCard.size(); i++) {
                if(myCard.get(i) == deleted2) myCard.remove(i);
            }
        }

        // 코인 2개 쓰는 경우
        if(coin >= 2) {
            myCard.add(deleted1);
            myCard.add(deleted2);

            for(int i = 0; i < myCard.size(); i++) {
                for(int j = i + 1; j < myCard.size(); j++) {
                    if(myCard.get(i) + myCard.get(j) == target) {
                        int usedCard1 = myCard.get(i);
                        int usedCard2 = myCard.get(j);

                        myCard.remove(j);
                        myCard.remove(i);

                        bruteForce(cards, coin - 2, nextCardIdx + 2, roundCount + 1);

                        if(usedCard1 != deleted1 || usedCard1 != deleted2) {
                            myCard.add(usedCard1);
                        }

                        if(usedCard2 != deleted1 || usedCard2 != deleted2) {
                            myCard.add(usedCard2);
                        }
                    }
                }
            }

            for(int i = myCard.size() - 1; i >= 0; i--) {
                if(myCard.get(i) == deleted1 || myCard.get(i) == deleted2) {
                    myCard.remove(i);
                    break;
                }
            }

            for(int i = myCard.size() - 1; i >= 0; i--) {
                if(myCard.get(i) == deleted1 || myCard.get(i) == deleted2) {
                    myCard.remove(i);
                    break;
                }
            }
        }

    }
}
