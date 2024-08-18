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
        // 규칙을 찾기 위해서는 같은 변의 크기를 기준으로 다른 변의 크기를 변동해봐야 한다. 집에 가서 노트를 사용해보자
        //
        // 규칙은 두 수의 최대공약수를 구하고 각 변을 최대공약수로 나눈 후에
        // 더하고 최대 공약수를 곱하면 제외되는 사각형이 나오고 총 사각형에서 빼면 된다.


        long total = (long)w * (long)h;
        long GCD = GetGreatestCommonDivisor(w, h);

        return total - (((w / GCD) + (h / GCD) - 1) * GCD);
    }

    private static int GetGreatestCommonDivisor(int w, int h) {
        if (h == 0) {
            return w;
        } else {
            return GetGreatestCommonDivisor(h, w % h);
        }
    }
}


