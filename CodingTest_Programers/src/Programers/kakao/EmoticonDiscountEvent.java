package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class EmoticonDiscountEvent {
    static int maxSubscriber = 0;
    static int maxSales = 0;
//    static Stack<Integer> visited;

    static int[] visited;
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

//        visited = new Stack<>();
        visited = new int[emoticons.length];
        emoticonsDiscountRate = new int[emoticons.length];

        bruteForce(users, emoticons, 0);

        return new int[]{maxSubscriber, maxSales};
    }

    private static void bruteForce(int[][] users, int[] emoticons, int discountCount) {
        if (discountCount == emoticons.length) {
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
            for (int i = 0; i < emoticons.length; i++) {
                for (int j = 1; j <= 4; j++) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        int originalPrice = emoticons[i];
                        emoticonsDiscountRate[i] = j * 10;
                        emoticons[i] =  (int)(emoticons[i] * ((10 - j) * 0.1));
                        bruteForce(users, emoticons, discountCount + 1);
                        emoticons[i] = originalPrice;
                        visited[i] = 0;
                    }
                }
            }
        }
    }

    private static int[] calculateSubscriber(int[][] users, int[] discountedEmoticons) {
        int subscriber = 0;
        int sales = 0;
        for (int i = 0 ; i < users.length; i++) {
            int totalPrice = 0;
            for (int j = 0; j < discountedEmoticons.length; j++) {
                if (emoticonsDiscountRate[j] >= users[i][0]) {
                    totalPrice += discountedEmoticons[j];
                }
            }

            if (totalPrice >= users[i][1]) subscriber++;
            else sales += totalPrice;
        }

        return new int[]{subscriber, sales};
    }

}
