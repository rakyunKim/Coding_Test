package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number1620 {
    static Map<String, Integer> nameKey = new HashMap<>();
    static Map<String, String> numberKey = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int pokemonCount = scanner.nextInt();
        int questionCount = scanner.nextInt();
        for(int i = 1; i <= pokemonCount; i++){
            String name = scanner.next();
            nameKey.put(name, i);
            numberKey.put(String.valueOf(i), name);
        }

        for(int i = 0; i < questionCount; i++){
            String question = scanner.next();
            if(nameKey.containsKey(question)){
                System.out.println(nameKey.get(question));
            }
            else {
                System.out.println(numberKey.get(question));
            }
        }

//        System.out.println(nameKey);
//
//        System.out.println("--------------------------------------------");
//
//
//        System.out.println(numberKey);
    }
}
