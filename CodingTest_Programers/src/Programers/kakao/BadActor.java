package Programers.kakao;

import Baekjoon.소마코테준비.ForMingi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BadActor {
    static int count;
    static boolean[] visited;
    static List<List<Integer>> completeGroup;
    public static void main(String[] args) throws IOException {
        String[] user_id = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};

        String[] banned_id = new String[]{"fr*d*", "abc1**"};
//        String[] banned_id = new String[]{"*rodo", "*rodo", "******"};
//        String[] banned_id = new String[]{"fr*d*", "*rodo", "******", "******"};
        int result = solution(user_id, banned_id);
        System.out.println(result);
    }

    public static int solution(String[] user_id, String[] banned_id) {
        // user_id의 크기가 8이고 banned_id의 크기도 user_id 보다 작거나 같고 한 이름의 원소의 크기도 8이므로
        // for문을 돌면서 banned_id 안에 있는 이름 원소와 내가 현재 타겟하고 있는 이름 원소를 비교 가능

        count = 0;
        visited = new boolean[user_id.length];
        completeGroup = new ArrayList<>();
        for (int i = 0; i < user_id.length; i++) {
            if (checkElement(user_id[i], banned_id[0])) {
                visited[i] = true;
                dfs(1, user_id, banned_id);
                visited[i] = false;
            }
        }

        return count;
    }

    private static void dfs(int depth, String[] userId, String[] bannedId) {
        if (depth == bannedId.length) {
            if (checkGroup(bannedId.length)){
                makeCompleteGroup();
                count++;
            }
        } else {
            for (int i = 0; i < userId.length; i++) {
                if (!visited[i] && checkElement(userId[i], bannedId[depth])) {
                    visited[i] = true;
                    dfs(depth + 1, userId, bannedId);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean checkGroup(int bannedLength) {
        List<Integer> currentVisitedGroup = new ArrayList<>();
        for (int i = 0; i < visited.length; i++){
            if (visited[i]) {
                currentVisitedGroup.add(i);
            }
        }
        Collections.sort(currentVisitedGroup);
        for (List<Integer> group : completeGroup) {
            int sameElementCount = 0;
            for (int i = 0; i < group.size(); i++) {
                if (group.get(i) == currentVisitedGroup.get(i)) {
                    sameElementCount++;
                }
            }
            if (sameElementCount == group.size()) {
                return false;
            }
        }
        return true;
    }

    private static void makeCompleteGroup() {
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                group.add(i);
            }
        }
        Collections.sort(group);
        completeGroup.add(group);
    }

    private static boolean checkElement(String user, String ban) {
        if (user.length() == ban.length()) {
            char[] charUser = user.toCharArray();
            char[] charBan = ban.toCharArray();
            for (int i = 0; i < user.length(); i++) {
                if (charUser[i] != charBan[i] && charBan[i] != '*') {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
