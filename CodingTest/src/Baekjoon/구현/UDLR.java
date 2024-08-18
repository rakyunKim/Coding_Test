package Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UDLR {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int mapSize = Integer.parseInt(bf.readLine());

        Queue<String> planner = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()){
            planner.add(st.nextToken());
        }

        int y = 1;
        int x = 1;
        while (!planner.isEmpty()){
            String nextPoint = planner.poll();
            if(nextPoint.equals("U") && y - 1 > 0) y -= 1;
            if(nextPoint.equals("D") && y + 1 <= mapSize) y += 1;
            if(nextPoint.equals("L") && x - 1 > 0) x -= 1;
            if(nextPoint.equals("R") && x + 1 <= mapSize) x += 1;
        }

        System.out.println(y + " " + x);

        bf.close();
    }
}
