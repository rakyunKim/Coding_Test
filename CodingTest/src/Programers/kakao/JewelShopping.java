package Programers.kakao;

import java.io.IOException;
import java.util.*;

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
        int kind = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, start = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }

            if (map.size() == kind && length > (end - start)) {
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }
}
