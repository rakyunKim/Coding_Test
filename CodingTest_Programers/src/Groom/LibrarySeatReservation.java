package Groom;
//프로그래머스에서는 main함수 및 입출력문이 필요하지 않습니다. 대신 solution함수만 작성하면 됩니다.
import java.util.*;
public class LibrarySeatReservation {
    static int answer = 0;
    static Stack<int[]> picked = new Stack<>();

    public static int solution(int[] s, int[]e, int N){
        Comparator<int[]> comparator = (a, b) -> a[1] - b[1];
        List<int[]> time = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            time.add(new int[]{s[i], e[i]});
        }

        time.sort(comparator);
        int[] min = time.get(0);
        time.remove(0);

        getMaxStudentCount(time, min[1], 0, 1);

        return answer;
    }

    public static void getMaxStudentCount(List<int[]> time, int prevEndTime, int nextIndex, int currentCount) {
        boolean isChanged = false;

        for (int i = nextIndex; i < time.size(); i++) {
            int[] next = time.get(i);

            if (next[0] >= prevEndTime) {
                isChanged = true;

                picked.add(time.get(i));

                getMaxStudentCount(time, next[1], i + 1, currentCount + 1);

                picked.pop();
            }
        }

        if (!isChanged) {
            List<int[]> copy = new ArrayList<>();

            for (int[] ele : time) {
                if (!picked.contains(ele)) copy.add(ele);
            }

            int secondCount = getSecondSeatMaxCount(copy);

            answer = Math.max(answer, secondCount + currentCount);
        }
    }

    public static int getSecondSeatMaxCount(List<int[]> copy) {
        int[] min = copy.get(0);
        int prevEndTime = min[1];
        int result = 1;

        for (int[] next : copy) {
            if (next[0] >= prevEndTime) {
                prevEndTime = next[1];
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int s[] = new int[1000];
        int e[] = new int[1000];
        int N;
        N = scan.nextInt();
        for(int i = 0; i < N; i++)
            s[i] = scan.nextInt();
        for(int i = 0; i < N; i++)
            e[i] = scan.nextInt();
        System.out.print(solution(s, e, N));
    }
}