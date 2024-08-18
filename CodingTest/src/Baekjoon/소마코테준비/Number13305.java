package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number13305 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int cityCount = scanner.nextInt();
        long[] loadLength = new long[cityCount];
        long totalLength = 0;
        for(int i = 0; i < cityCount - 1; i++){
            loadLength[i] = scanner.nextLong();
            totalLength += loadLength[i];
        }

        long[] oilPrice = new long[cityCount];
        for(int i = 0; i < cityCount; i++){
            oilPrice[i] = scanner.nextLong();
        }

        long minimumOilPrice = 1000000001;
        long minimumOilCityNumber = 0;
        for(int i = 0; i < cityCount - 1; i++){
            if(oilPrice[i] < minimumOilPrice){
                minimumOilPrice = oilPrice[i];
                minimumOilCityNumber = i;
            }
        }

        long totalOilPrice = 0;
        for(int i = 0; i < cityCount - 1; i++){
            if(i == minimumOilCityNumber){
                totalOilPrice += minimumOilPrice * totalLength;
                break;
            } else{
                totalOilPrice += oilPrice[i] * loadLength[i];
                totalLength -= loadLength[i];
            }
        }

        System.out.println(totalOilPrice);
    }
}
