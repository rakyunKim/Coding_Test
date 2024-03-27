package Programers.kakao;

import java.io.IOException;
import java.util.*;


public class Tuple {
    public static void main(String[] args) throws IOException {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//        String s = "{{20,111},{111}}";
//        String s = "{{123}}";
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        List<Integer> result = solution(s);
        System.out.println(result);
    }

    private static List<Integer> solution(String s) {
        // s에서 원소가 하나인 집합을 찾아서 그 집합을 튜플의 가장 첫 번째 인덱스에 넣고
        // 그 다음 두 번째 원소 세 번째 원소 이렇게 늘려가며 튜플의 다음 인덱스 다음 인덱스에 넣는다.
        // 이 때 for문 안에서 집합 안의 원소가 이미 튜플에 있는 수라면 그 수를 제외하고 튜플에
        // 있지 않은 수를 튜플의 다음 인덱스에 넣는다.

        char[] temp = s.toCharArray();
        temp[0] = ' ';
        temp[temp.length - 1] = ' ';
        s = String.valueOf(temp);
        s = s.trim();

        String[] group = s.split("},");

        for (int i = 0; i < group.length; i++) {
            temp = group[i].toCharArray();
            temp[0] = ' ';
            group[i] = String.valueOf(temp);
            group[i] = group[i].trim();
        }

        temp = group[group.length - 1].toCharArray();
        temp[temp.length - 1] = ' ';
        group[group.length - 1] = String.valueOf(temp);
        group[group.length - 1] = group[group.length - 1].trim();
        Arrays.sort(group, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < group.length; i++) {
            String[] current = group[i].split(",");
            for (String a : current) {
                int parseInt = Integer.parseInt(a);
                if (!answer.contains(parseInt)){
                    answer.add(parseInt);
                }
            }
        }

        return answer;
    }
}
