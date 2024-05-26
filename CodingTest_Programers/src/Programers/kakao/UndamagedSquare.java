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
        // 직사각형인 경우에는 각 대각의 꼭짓점을 이으면 작은변 x 2 만큼의 사각형을 사용하지 못한다.
        // 처음엔 위와 같이 생각했는데 코드가 계속 실패하는 것을 보고 다시 생각했다.
        // 일단 가로 변과 세로 변의 크기 차이가 많이 나면 내가 세운 작은변 x 2만큼의 사각형을 사용하지 못한다는 가설을 안 된다.
        // 즉 가로 변과 세로 변의 크기 차이에 따라 사용하지 못하는 사각형의 개수가 달라진다.
        // 그 규칙을 찾아야 한다.


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


