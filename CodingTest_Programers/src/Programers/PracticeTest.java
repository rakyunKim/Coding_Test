package Programers;

import java.io.IOException;
import java.util.*;

public class PracticeTest {
    public static void main(String[] args) throws IOException {
//        int[] answer = new int[]{1,2,3,4,5};
        int[] answer = new int[]{1,3,2,4,2};

        System.out.println(solution(answer));
    }

    public static List<Integer> solution(int[] answers) {
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        Queue<Integer> third = new LinkedList<>();

        for (int i = 1; i <=5 ; i++) {
            first.add(i);
        }

        second.add(2);
        second.add(1);
        second.add(2);
        second.add(3);
        second.add(2);
        second.add(4);
        second.add(2);
        second.add(5);

        third.add(3);
        third.add(3);
        third.add(1);
        third.add(1);
        third.add(2);
        third.add(2);
        third.add(4);
        third.add(4);
        third.add(5);
        third.add(5);

        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int firstAnswer = first.poll();
            int secondAnswer = second.poll();
            int thirdAnswer = third.poll();

            if (answer == firstAnswer) firstScore++;
            if (answer == secondAnswer) secondScore++;
            if (answer == thirdAnswer) thirdScore++;

            first.add(firstAnswer);
            second.add(secondAnswer);
            third.add(thirdAnswer);
        }
        List<Integer> answer = new ArrayList<>();
        int maxScore = Math.max(Math.max(firstScore, secondScore), thirdScore);
        if (maxScore == firstScore) answer.add(1);
        if (maxScore == secondScore) answer.add(2);
        if (maxScore == thirdScore) answer.add(3);
        return answer;
    }
}
