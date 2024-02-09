package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;
public class Number1976 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(buffer.readLine());
        int travelCityCount = Integer.parseInt(buffer.readLine());

        parent = new int[cityCount + 1];
        for(int i = 1; i <= cityCount; i++){
            parent[i] = i;
        }

        for(int i = 1; i <= cityCount; i++){
            StringTokenizer st = new StringTokenizer(buffer.readLine()) ;
            for(int j = 1; j <= cityCount; j++){
                int isPossible = Integer.parseInt(st.nextToken());
                if(isPossible == 1){
                    union(i, j);
                }
            }
        }

        boolean isPossible = true;
        StringTokenizer st = new StringTokenizer(buffer.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        for(int i = 0; i < travelCityCount - 1; i++){
            int nextCity = Integer.parseInt(st.nextToken());
            if(find(startCity) != find(nextCity)){
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }




//        for(int i = 0; i < cityCount; i++){
//            for(int j = 0; j < cityCount; j++){
//                System.out.print(possibility[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void union(int cityOne, int cityTwo) {
        int cityOneParent = find(cityOne);
        int cityTwoParent = find(cityTwo);
        if(cityOneParent < cityTwoParent){
            parent[cityTwoParent] = cityOneParent;
        } else{
            parent[cityOneParent] = cityTwoParent;
        }
    }

    private static int find(int city) {
        if(parent[city] == city) return city;
        else{
            return parent[city] = find(parent[city]);
        }
    }
}
