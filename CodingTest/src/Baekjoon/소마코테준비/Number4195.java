package Baekjoon.소마코테준비;

import java.util.*;
import java.io.*;
public class Number4195 {
    static int[] parent;
    static int[] level;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < testCase; t++){
            int friendShipCount = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            parent = new int[friendShipCount * 2];
            level = new int[friendShipCount * 2];
            for(int i = 0; i < friendShipCount * 2; i++){
                parent[i] = i;
                level[i] = 1;
            }

            int idx = 0;
            for(int i = 0; i < friendShipCount; i++){
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
                if(!map.containsKey(first)){
                    map.put(first, idx++);
                }
                if(!map.containsKey(second)){
                    map.put(second, idx++);
                }
                sb.append(union(map.get(first), map.get(second)) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int union(int first, int second) {
        int firstP = find(first);
        int secondP = find(second);

        if(firstP < secondP){
            parent[secondP] = find(firstP);
            level[firstP] += level[secondP];
            level[secondP] = 1;
            return level[firstP];
        } else {
            parent[firstP] = find(secondP);
            level[secondP] += level[firstP];
            level[firstP] = 1;
            return level[secondP];
        }
    }

    private static int find(int index) {
        if(parent[index] == index) return index;
        else return parent[index] = find(parent[index]);
    }
}
