package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class RalroRalro {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        List<Integer> answer = new ArrayList<>();
        for(int i = 2400; i < 10000000; i++){
            String s = String.valueOf(i);
            if(s.contains("2400")){
                System.out.println(i);
                answer.add(i);
            }
        }
        System.out.println(answer.get(target));
    }
}
