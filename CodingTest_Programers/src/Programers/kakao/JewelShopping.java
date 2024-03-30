package Programers.kakao;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JewelShopping {
    public static void main(String[] args) throws IOException {
        String[] gems = new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = new String[]{"XYZ", "XYZ", "XYZ"};
//        String[] gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        int[] result = solution(gems);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String[] gems) {
        Set<String> uniqueGemsSet = new HashSet<>(Arrays.asList(gems));

//        for (String gem : uniqueGemsSet) {
//            System.out.println(gem);
//        }



        int[] answer = {};
        return answer;
    }
}
