package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class EmoticonDiscountEvent {
    static int maxSubscriber = 0;
    static int maxSales = 0;
//    static Stack<Integer> visited;
    static int[] emoticonsDiscountRate;
    public static void main(String[] args) throws IOException {
        // 먼저 유저의 희망 할인률을 내림차순 정렬한다.
        // 그리고 유저의 희망 할인률의 최대치 부터 낮추면서 이모티콘 플러스 가입자가
        // 최대가 되는 순간을 찾는다.
        // 찾았다면, 이모티콘 플러스 가입자의 수가 바뀌지 않는 선에서 할인률을 낮춘다.


//        int[][] users = new int[][]
//                {
//                    {40, 10000},
//                    {25, 10000}
//                };


        int[][] users = new int[][]
                {
                        {40, 2900},
                        {23, 10000},
                        {11, 5200},
                        {5, 5900},
                        {40, 3100},
                        {27, 9200},
                        {32, 6900}
                };


//        int[] emoticons = new int[]{7000, 9000};
        int[] emoticons = new int[]{1300, 1500, 1600, 4900};

        int[] result = solution(users, emoticons);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        Arrays.sort(users, Comparator.comparingInt(a -> -a[0]));

        emoticonsDiscountRate = new int[emoticons.length];

        bruteForce(users, emoticons, 0);

        return new int[]{maxSubscriber, maxSales};
    }

    private static void bruteForce(int[][] users, int[] emoticons, int start) {
        if (start == emoticons.length) {
            int[] subscriberAndSales = calculateSubscriber(users, emoticons);

            if (maxSubscriber < subscriberAndSales[0]) {
                maxSubscriber = subscriberAndSales[0];
                maxSales = subscriberAndSales[1];
            }
            else if (maxSubscriber == subscriberAndSales[0]) {
                maxSales = Math.max(maxSales, subscriberAndSales[1]);
            }
        }
        else
        {
            for (int i = 10; i <= 40; i += 10) {
                emoticonsDiscountRate[start] = i;
                bruteForce(users, emoticons, start + 1);
            }
        }
    }

    private static int[] calculateSubscriber(int[][] users, int[] emoticons) {
        int subscriber = 0;
        int sales = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int maxPrice = user[1];
            int totalPrice = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (emoticonsDiscountRate[i] >= minDiscount) {
                    totalPrice += (emoticons[i]/100) * (100 - emoticonsDiscountRate[i]);
                }
            }

            if (totalPrice >= maxPrice) subscriber++;
            else sales += totalPrice;
        }

        return new int[]{subscriber, sales};
    }
}
