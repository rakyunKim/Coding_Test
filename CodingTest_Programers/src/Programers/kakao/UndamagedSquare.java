package Programers.kakao;

import java.io.IOException;

public class UndamagedSquare {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int w = 8;
        int h = 4;
        System.out.println(solution(w, h));
    }

    public static long solution(int w, int h) {
        // 정사각형인 경우에는 각 대각의 꼭짓점을 이으면 한 변의 길이만큼 사각형을 사용하지 못하고
        // 직사각형인 경우에는 각 대각의 꼭짓점을 이으면 가로 x 2 만큼의 사각형을 사용하지 못한다.

        long total = (long)w * (long)h;

        if (w == h) return total - w;

        if (w == 1 || h == 1) return 0;

        if(w == 2) return total - h;

        if(h == 2) return total - w;

        h = h * 2;
        w = w * 2;

        if (w > h) return total - h;

        else return total - w;
    }
}


