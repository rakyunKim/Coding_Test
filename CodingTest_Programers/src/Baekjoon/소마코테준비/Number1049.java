package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1049 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();
        int minPackageCount = target / 6 + 1;
        int brandCount = scanner.nextInt();

        int[] packagePrice = new int[brandCount];
        int[] separatePrice = new int[brandCount];

        for(int i = 0; i < brandCount; i++){
            packagePrice[i] = scanner.nextInt();
            separatePrice[i] = scanner.nextInt();
        }
        Arrays.sort(packagePrice);
        Arrays.sort(separatePrice);

        int minValue = 0;

        if(target > 6){
            int allPackage = packagePrice[0] * minPackageCount;
            int packageAndSeparate = packagePrice[0] * (minPackageCount - 1) + ((target - (minPackageCount - 1) * 6) * separatePrice[0]);
            int allSeparate = target * separatePrice[0];
            minValue = Math.min(Math.min(allPackage, packageAndSeparate),allSeparate);
        } else{
            minValue = Math.min(packagePrice[0], target * separatePrice[0]);
        }

        System.out.println(minValue);
    }
}
