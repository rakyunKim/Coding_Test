package Baekjoon.소마코테준비;
import java.util.*;
public class Number1748 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        // 자리수마다 더해주는 값
        // 1의 자리 부터 시작해서 초기값 1
        int plus = 1;
        // 자리수를 명시해주는 값
        int num = 10;
        int N = scanner.nextInt();
        for(int i = 1; i <= N; i++){
            // 만약 i = 1이면 10으로 나누어 떨어지지 않음 즉 10의 자리가 아님 그러면 plus는 변하지 않고 count에 +1을 함
            if(i % num == 0){
                // 만약 num으로 나누어 떨어졌다면 i는 10이상인 수인 경우 즉 자리수가 두 자리이기에 자리수를 나타내는 plus를 +1 해주고 몇의 자리보다 아래인지 명시하는 num이라는 값을 곱하기 10해서 올림
                plus ++;
                num *= 10;
            }
            count += plus;
        }
        System.out.println(count);
    }
}
