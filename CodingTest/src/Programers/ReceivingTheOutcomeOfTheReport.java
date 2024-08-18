package Programers;

import java.io.IOException;
import java.util.*;

public class ReceivingTheOutcomeOfTheReport {
    public static void main(String[] args) throws IOException {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
//        String[] id_list = new String[]{"con", "ryan"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        String[] report = new String[]{"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
//        int k = 3;
        int[] result = solution(id_list, report, k);
        for (int i : result){
            System.out.print(i + " ");
        }
    }

    static public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> receiveCount = new HashMap<>();

        ArrayList<String>[] reportList = new ArrayList[id_list.length];
//        ArrayList<String>[] receiveList = new ArrayList[id_list.length];
        for (int i = 0; i < id_list.length; i++){
            reportList[i] = new ArrayList<>();
        }

        for (String a : report){
            String[] temp = a.split(" ");
            String reporter = temp[0];

            String receiver = temp[1];

            for (int i = 0; i < id_list.length; i++){
                if (id_list[i].equals(reporter) && !reportList[i].contains(receiver)){
                    reportList[i].add(receiver);
                    if (receiveCount.containsKey(receiver)){
                        int receive = receiveCount.get(receiver);
                        receiveCount.put(receiver, receive + 1);
                    } else {
                        receiveCount.put(receiver, 1);
                    }
                }
            }
        }


        int[] answer = new int[id_list.length];
        for (String a : id_list){
            if (receiveCount.containsKey(a) && receiveCount.get(a) >= k){
                for (int i = 0; i < id_list.length; i++){
                    ArrayList<String> temp = reportList[i];
                    if (temp.contains(a)){
                        answer[i] ++;
                    }
                }
            }
        }
        return answer;
    }
}
