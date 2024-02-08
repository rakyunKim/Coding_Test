package Baekjoon.소마코테준비;
import java.util.*;
public class Number1309Retry {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        int[][] dp = new int[target + 1][3];
        dp[0][0] = 1; // 동물원에 아무 사자도 두지 않는 경우를 1로 보고 1을 더함
        for(int i = 1; i <= target; i++){
            // dp에서 x가 0인 경우는 그 줄에 아무 사자도 두지 않는 경우의 수를 의마하는데
            // 그 줄에 아무 사자도 두지 않는 경우의 수는 그 전 줄에 있는 모든 경우의 수를 더한 값과 같다.
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;

            // dp에서 x가 1인 경우는 그 줄의 1번째에 사자를 두겠다는 의미인데,
            // 이는 그 전 줄에서 1번에만 사자를 두지 않았다면 현재 줄의 1번에 사자를 둘 수 있으므로
            // 그 전 줄의 1번째 경우의 수를 제외하고 더한 값을 넣는다.
            dp[i][1] = (dp[i - 1][0] + dp[i -1 ][2]) % 9901;;

            // dp에서 x가 2인 경우는 위와 같이 그 줄의 2번째에 사자를 두겠다는 의미로
            // 이 전 줄의 2번째를 제외한 0번과 1번을 더한다.
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int answer = 0;
        for(int i = 0; i < 3; i++){
            answer += dp[target][i];
        }
        System.out.println(answer % 9901);
    }
}
