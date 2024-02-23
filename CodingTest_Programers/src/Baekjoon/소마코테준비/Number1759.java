package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number1759 {
    static int alphabetCount;
    static int secretNumCount;
    static String[] alphabet;
    static Stack<String> print = new Stack<>();
    static int[] visited;
    static List<String> moeum = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        secretNumCount = Integer.parseInt(st.nextToken());
        alphabetCount = Integer.parseInt(st.nextToken());
        alphabet = new String[alphabetCount];
        visited = new int[alphabetCount];

        moeum.add("a");
        moeum.add("e");
        moeum.add("i");
        moeum.add("o");
        moeum.add("u");

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < alphabetCount; i++){
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);

        backtracking(0,0);

    }

    private static void backtracking(int start, int depth) {
        if(depth == secretNumCount){
            if(validate(print)){
                for(Object a : print){
                    System.out.print(a);
                }
                System.out.println();
            }
            return;
        }

        for(int i = start; i < alphabetCount; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                print.push(alphabet[i]);
                backtracking(i + 1, depth + 1);
                print.pop();
                visited[i] = 0;
            }
        }
    }

    private static boolean validate(Stack<String> print) {
        int jaeumCount = 0;
        int moeumCount = 0;
        for(Object a : print){
            if(moeum.contains(a)){
                moeumCount++;
            }
            else{
                jaeumCount++;
            }
        }
        if(moeumCount > 0 && jaeumCount > 1){
            return true;
        }
        else{
            return false;
        }
    }
}
