package Baekjoon.소마코테준비;
import java.util.*;
public class Number15652Retry {
    static int numberRange;
    static int numberCount;
    static int[] forPrint;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        numberRange = scanner.nextInt();
        numberCount = scanner.nextInt();
        forPrint = new int[numberCount];

        backTracking(1, 0);
    }

    private static void backTracking(int currentNumber, int depth) {
        if(depth < numberCount){
            for(int i = currentNumber; i <= numberRange; i++){
                forPrint[depth] = i;
                backTracking(i, depth + 1);
            }
        } else{
            for(int i : forPrint){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
