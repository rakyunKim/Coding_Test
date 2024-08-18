package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class TakingGroupPhotos {
    static int answer = 0;
    static String[] group = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
    public static void main(String[] args) throws IOException {
        int n = 2;
//        String[] data = new String[]{"N~F=0", "R~T>2"};
        String[] data = new String[]{"M~C<2", "C~M>1"};
//        String[] data = new String[]{"N~F=2", "R~T<4"};
        System.out.println(solution(n ,data));
    }
    public static int solution(int n, String[] data) {
        // {A, C, F, J, M, N, R, T} 다음 8개로 순열 조합을 만든다.
        // 완탐으로 만들다가 8개의 숫자가 모였다면,
        // checkData(String[] group, String dataElement);를 실행
        // 가능하다면 answer++

        searchAll(new ArrayList<>(), data);

        return answer;
    }

    private static void searchAll(List<String> choose,  String[] data) {
        if (choose.size() == group.length) {
            boolean isPossible = true;
            for (int i = 0; i < data.length; i++) {
               if (!checkData(choose, data[i])) {
                   isPossible = false;
                   break;
               }
            }
            if (isPossible) {
                for (String s : choose) {
                    System.out.print(s + " ");
                }
                System.out.println();
                System.out.println("=======================");
                answer++;
            }
        } else {
            for (int i = 0; i < group.length; i++) {
                if (!choose.contains(group[i])) {
                    choose.add(group[i]);
                    searchAll(choose, data);
                    choose.remove(choose.size() - 1);
                }
            }
        }
    }

    private static boolean checkData(List<String> choose, String dataElement) {
        String firstFriend = String.valueOf(dataElement.charAt(0));
        String secondFriend = String.valueOf(dataElement.charAt(2));
        String distanceWay = String.valueOf(dataElement.charAt(3));
        int distance = Integer.parseInt(String.valueOf(dataElement.charAt(4)));

        int firstFriendIndex = 0;
        int secondFriendIndex = 0;


        for (int i = 0; i < choose.size(); i++) {
            if (choose.get(i).equals(firstFriend)) {
                firstFriendIndex = i;
            }
            if (choose.get(i).equals(secondFriend)) {
                secondFriendIndex = i;
            }
        }

        int friendsDistance = Math.abs(firstFriendIndex - secondFriendIndex) - 1;
        if (distanceWay.equals("=")) {
            return friendsDistance == distance;
        } else if (distanceWay.equals("<")) {
            return friendsDistance < distance;
        } else {
            return friendsDistance > distance;
        }
    }
}
