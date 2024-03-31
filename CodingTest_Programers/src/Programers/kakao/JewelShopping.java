package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class JewelShopping {
    public static void main(String[] args) throws IOException {
//        String[] gems = new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
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

        List<String> selected = new ArrayList<>();
        int start = 1;
        int end = 0;
        for (int i = 0; i < gems.length; i++) {
            if (!selected.contains(gems[i])) {
                selected.add(gems[i]);
                end = i + 1;
            } else {
                if (selected.get(0).equals(gems[i])) {
                    selected.remove(0);
                    start++;
                    selected.add(gems[i]);
                    if (selected.size() >= 2) {
                        if (selected.get(0).equals(selected.get(1))) {
                            selected.remove(0);
                            start++;
                        }
                    }
                } else {
                    selected.add(gems[i]);
                }
            }
        }

        return new int[]{start, end};
    }
}
