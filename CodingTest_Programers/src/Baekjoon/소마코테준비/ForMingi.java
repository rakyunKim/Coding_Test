package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class ForMingi {
    static Scanner scanner;
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);

        System.out.println("당신의 이름을 입력하세요");
        String name = scanner.next();
        System.out.println(name + "님 반갑습니다!");

        System.out.println("숫자 놀이를 시작합니다.");
        while (true){
            System.out.println("1번 : 더하기 || 2번 빼기 || 3번 곱하기 || 4번 나누기");
            System.out.println("원하는 놀이 번호를 입력하세요");
            int playNumber = scanner.nextInt();
            int answerCount = playNumber == 1 ? plusOperation() : playNumber == 2 ? minusOperation() : playNumber == 3 ?
                    multiplicationOperation() : playNumber == 4 ? dvisionOperation() : -1;
            if(answerCount == -1) System.out.println("올바른 번호를 입력해주세요");
            if(answerCount < 5) System.out.println(name + " 멍청이");
            else if(answerCount < 9) System.out.println(name + " 똥 멍청이는 아니네");
            else if(answerCount == 13) System.out.println(name + " 천재냐 ??");
            System.out.println("계속하시겠습니까?");
            System.out.println("1번 계속 진행 2번 스탑");
            int a = scanner.nextInt();
            if(a != 1){
                break;
            }
        }

    }
    private static int multiplicationOperation(){
        int count = 0;
        System.out.println("1 곱하기 1은 ?");
        int answer = scanner.nextInt();
        if(answer != 1){
            System.out.println("땡 !!!");
        }else {
            System.out.println("정답 !!! ");
            count ++;
        }

        System.out.println("20 곱하기 100은 ?");
        answer = scanner.nextInt();
        if(answer != 2000) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        System.out.println("123414 곱하기 12312은 ?");
        answer = scanner.nextInt();
        int operation = 123414 * 12312;
        if(answer != operation) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        return count;
    }

    private static int minusOperation(){
        int count = 0;
        System.out.println("1 빼기 1은 ?");
        int answer = scanner.nextInt();
        if(answer != 0){
            System.out.println("땡 !!!");
        }else {
            System.out.println("정답 !!! ");
            count ++;
        }

        System.out.println("100 빼기 9는 ?");
        answer = scanner.nextInt();
        if(answer != 91) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        System.out.println("12345123 빼기 123412은 ?");
        answer = scanner.nextInt();
        int operation = 12345123 - 123412;
        if(answer != operation) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        return count;
    }
    private static int plusOperation() {
        int count = 0;
        System.out.println("1 더하기 1은 ?");
        int answer = scanner.nextInt();
        if(answer != 2){
            System.out.println("땡 !!!");
        }else {
            System.out.println("정답 !!! ");
            count ++;
        }

        System.out.println("10 더하기 100은 ?");
        answer = scanner.nextInt();
        if(answer != 110) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        System.out.println("10000 더하기 12315111은 ?");
        answer = scanner.nextInt();
        if(answer != 12316111) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        return count;
    }
    private static int dvisionOperation() {
        int count = 0;
        System.out.println("1 나누기 1은 ?");
        int answer = scanner.nextInt();
        if(answer != 1){
            System.out.println("땡 !!!");
        }else {
            System.out.println("정답 !!! ");
            count ++;
        }

        System.out.println("10 나누기 5 ?");
        answer = scanner.nextInt();
        if(answer != 2) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        System.out.println("10000 나누기 10은 ?");
        answer = scanner.nextInt();
        if(answer != 1000) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }

        System.out.println("12314123 나누기 1231222의 나머지는 ?");
        answer = scanner.nextInt();
        int operation = 12314123 % 1231222;
        if(answer != operation) System.out.println("땡 !!!");
        else {
            System.out.println("정답 !!!");
            count ++;
        }
        return count;
    }
}
