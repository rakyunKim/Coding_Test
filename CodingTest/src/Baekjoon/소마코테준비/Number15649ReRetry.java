package Baekjoon.소마코테준비;
import java.util.*;
public class Number15649ReRetry {
    static int numberRange;
    static int maxDepth;
    static List<Integer> visited;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        numberRange = scanner.nextInt();
        maxDepth = scanner.nextInt();
        visited = new ArrayList<>();

        backTracking(1);
    }

    private static void backTracking(int depth) {
        for(int i = 1; i <= numberRange; i++){
            if(!visited.contains(i)){
                visited.add(i);
                if(visited.size() == maxDepth){
                    for(int j : visited){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                } else{
                    backTracking(depth + 1);
                }
                visited.remove(depth - 1);
            }
        }
    }
}
