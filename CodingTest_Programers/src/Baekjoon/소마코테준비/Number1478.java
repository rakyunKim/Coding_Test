package Baekjoon.소마코테준비;

import java.util.*;
public class Number1478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earth = scanner.nextInt();
        int sun = scanner.nextInt();
        int moon = scanner.nextInt();


        int earthTarget = 0;
        int sunTarget = 0;
        int moonTarget = 0;

        int count = 0;
        while (earthTarget != earth || sunTarget != sun || moonTarget != moon) {
            earthTarget += 1;
            sunTarget += 1;
            moonTarget += 1;
            if (earthTarget > 15) {
                earthTarget = 1;
            }
            if (sunTarget > 28) {
                sunTarget = 1;
            }
            if (moonTarget > 19) {
                moonTarget = 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
