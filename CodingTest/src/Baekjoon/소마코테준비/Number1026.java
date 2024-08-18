package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int arrLength = Integer.parseInt(bf.readLine());
        int[] aArr = new int[arrLength];
        Integer[] bArr = new Integer[arrLength];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < arrLength; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < arrLength; i++){
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr, Collections.reverseOrder());

        int answer = 0;
        for(int i = 0; i < arrLength; i++){
            answer += aArr[i] * bArr[i];
        }
        System.out.println(answer);
    }
}
