package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class OpenChattingRoom {
    static Map<String, String> users = new HashMap<>();
    static Queue<String[]> inputs = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        String[] record = new String[]
                {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
                };

        String[] result = solution(record);

        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] record) {
        for (String s : record) {
            executeInput(s);
        }

        String[] answer = new String[inputs.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = saveInput(inputs.poll());
        }

        return answer;
    }

    private static void executeInput(String input) {
        String[] split = input.split(" ");

        String query = split[0];
        String userId = split[1];

        if (query.equals("Enter")) {
            if (users.get(userId) == null || !users.get(userId).equals(split[2])) {
                users.put(userId, split[2]);
            }

            inputs.add(new String[]{userId, "님이 들어왔습니다."});
        }
        else if (query.equals("Leave")) {
            inputs.add(new String[]{userId, "님이 나갔습니다."});
        }
        else {
            users.put(userId, split[2]);
        }
    }

    private static String saveInput(String[] poll) {
        String nickName = users.get(poll[0]);

        return nickName + poll[1];
    }

}
