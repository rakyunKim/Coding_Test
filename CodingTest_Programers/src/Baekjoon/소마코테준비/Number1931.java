package Baekjoon.소마코테준비;

import java.util.*;
import java.io.*;

public class Number1931 {
    static long[] meetingStartTime;
    static long[] meetingEndTime;
    static int count;
    static int meetingCount;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        meetingCount = Integer.parseInt(bf.readLine());
        meetingStartTime = new long[meetingCount];
        meetingEndTime = new long[meetingCount];

        for(int i = 0; i < meetingCount; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            meetingStartTime[i] = Integer.parseInt(st.nextToken());
            meetingEndTime[i] = Integer.parseInt(st.nextToken());
        }
        long min = 214748367;
        int minIndex = 0;
        max = 0;
        for(int i = 0; i < meetingCount; i++){
            if(meetingEndTime[i] < min) {
                min = meetingEndTime[i];
                minIndex = i;
            }
            if(i > max) max = i;
        }
        count = 1;

        while(minIndex < meetingCount - 1){
            long minimum = 214748367;
            for(int i = minIndex + 1; i < meetingCount; i++){
                if(meetingStartTime[i] >= min && meetingStartTime[i] <= minimum){
                    if(meetingEndTime[i] < minimum){
                        minimum = meetingEndTime[i];
                        minIndex = i;
                    }
                }
            }
            min = minimum;
            count++;
        }

        System.out.println(count);
    }

}
