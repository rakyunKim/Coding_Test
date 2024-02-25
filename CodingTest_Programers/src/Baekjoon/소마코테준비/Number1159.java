package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/*
    1. 배열에 알파벳을 집어 넣는다.
    2. 입력 받은 이름의 첫 번째 글자를 찾으며 같은 알파벳 배열에서 알파벳을 찾으면
       알파벳 배열의 인덱스와 같은 int 배열의 인덱스의 갑을 ++ 한다.
    3. int 배열을 순회하며 값이 5인 경우 같은 인덱스에 있는 알파벳을 출력한다.
---------------------------------------------------------------------
    1.  Map을 만들어서 이름의 첫 글자를 키 값으로 두고 같은 값이라면 벨류 값을 ++한다.
    2. 되려나?
 */

public class Number1159 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int[] count = new int[26];
//        Map<String, Integer> map = new HashMap<>();

        int playerCount = scanner.nextInt();
        for(int i = 0; i < playerCount; i++){
            String name = scanner.next();
            String firstWord = name.substring(0,1);
            for(int j = 0; j < alphabet.length; j++){
                if(firstWord.equals(alphabet[j])){
                    count[j] ++;
                }
            }
        }

        boolean isHave = false;
        for(int i = 0; i < count.length; i++){
            if(count[i] >= 5){
                System.out.print(alphabet[i]);
                isHave = true;
            }
        }

        if(!isHave){
            System.out.println("PREDAJA");
        }

//        boolean isHave = false;
//        for(int i = 5; i < playerCount; i++){
//            if(getKeyByValue(map,i) != null){
//                System.out.print(getKeyByValue(map,i));
//                isHave = true;
//            }
//        }
//
//        if(!isHave){
//            System.out.println("PREDAJA");
//        }
    }

//    public static void addOrUpdate(Map<String, Integer> map, String key) {
//        if (map.containsKey(key)) {
//            // 키가 이미 존재하는 경우 해당 키의 값을 가져와 1 증가시킴
//            map.put(key, map.get(key) + 1);
//        } else {
//            // 키가 존재하지 않는 경우 새로운 키-값 쌍을 추가함
//            map.put(key, 1);
//        }
//    }
//
//    public static String getKeyByValue(Map<String, Integer> map, int value) {
//        // Map의 entrySet을 얻음
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//
//        // entrySet을 순회하며 값이 일치하는 키를 찾음
//        for (Map.Entry<String, Integer> entry : entrySet) {
//            if (entry.getValue().equals(value)) {
//                return entry.getKey(); // 값이 일치하는 경우 해당 키 반환
//            }
//        }
//
//        return null; // 값이 일치하는 키를 찾지 못한 경우 null 반환
//    }
}
