package Programers;

public class SplittingPowerGridIntoTwo {
    static int answer = Integer.MAX_VALUE;
    static int[] visited;
    static int[] usedWires;
    public static void main(String[] args) {
        int n = 9;
//        int n = 4;
//        int n = 7;

        int[][] wires = new int[][]{
                {1,3},
                {2,3},
                {3,4},
                {4,5},
                {4,6},
                {4,7},
                {7,8},
                {7,9}
        };

//        int[][] wires = new int[][]{
//                {1, 2},
//                {2, 3},
//                {3, 4}
//        };

//        int[][] wires = new int[][]{
//                {1,2},
//                {2,7},
//                {3,7},
//                {3,4},
//                {4,5},
//                {6,7}
//        };

        System.out.println(solution(n, wires));
    }
    public static int solution(int n, int[][] wires) {
        // 전선을 끊는 로직과 전선이 끊겼을 때 왼쪽 네트워크의 송전탑 개수, 오른쪽 네트워크의 송전탑 개수를 세는 함수가 필요함
        visited = new int[n + 1];
        usedWires = new int[wires.length];

        for (int i = 0; i < wires.length; i++) {
            int element1 = wires[i][0];
            int element2 = wires[i][1];
            usedWires[i] = 1;

            visited[element1] = 1;
            int element1Count = countElectronicTopAt(element1, 1, wires);
            visited[element1] = 0;
            usedWires = new int[wires.length];

            usedWires[i] = 1;
            visited[element2] = 1;
            int element2Count = countElectronicTopAt(element2, 1, wires);
            visited[element2] = 0;
            usedWires = new int[wires.length];

            int differenceCountInElectronicTop = Math.abs(element1Count - element2Count);

            if (answer > differenceCountInElectronicTop) answer = differenceCountInElectronicTop;
        }


        return answer;
    }

    private static int countElectronicTopAt(int element, int count, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            if (usedWires[i] == 0) {
                int element1 = wires[i][0];
                int element2 = wires[i][1];
                usedWires[i] = 1;

                if (element1 == element) {
                    visited[element2] = 1;
                    return countElectronicTopAt(element1, count + 1, wires);
                }
                if (element2 == element) {
                    visited[element1] = 1;
                    return countElectronicTopAt(element2, count + 1, wires);
                }
            }
        }

        return count;
    }
}
