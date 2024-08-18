package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

/**
 * 파일 패턴을 입력 받아서 첫 번째 글자와 두 번째 글자를 변수에 저장한다.
 * 그리고 파일명을 입력 받으며 첫 번째 글자가 파일명 안에 있다면 그 인덱스를 기준으로
 * 뒤의 글자들 중 두 번째 글자가 있는지 찾고 있다면 DA를 출력 아니면 NE를 출력한다.
 */


public class Number9996 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int fileCount = scanner.nextInt();
        String filePattern = scanner.next();
        StringTokenizer st = new StringTokenizer(filePattern, "*");
        String start = st.nextToken();
        String end = st.nextToken();


//        for(String a : pattern){
//            System.out.println("패턴 :: " + a);
//        }

        for(int i = 0; i < fileCount; i++){
            String fileName = scanner.next();
            if(start.length() + end.length() > fileName.length()){
                System.out.println("NE");
            } else {
                String head = fileName.substring(0, start.length());
                String tail = fileName.substring(fileName.length() - end.length());

                if(head.equals(start) && tail.equals(end)){
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            }

        }
    }
}
