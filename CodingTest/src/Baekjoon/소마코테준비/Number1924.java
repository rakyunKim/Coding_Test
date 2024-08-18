package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number1924 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        if (month == 1 || month == 10) System.out.println(startMonday(day));
        if (month == 5) System.out.println(startTuesday(day));
        if (month == 8) System.out.println(startWendsday(day));
        if (month == 2 || month == 3 || month == 11) System.out.println(startThursday(day));
        if (month == 6) System.out.println(startFriday(day));
        if (month == 9 || month == 12) System.out.println(startSaturday(day));
        if (month == 4 || month == 7) System.out.println(startSunday(day));

    }

    private static String startMonday(int day) {
        if (day >= 7){
            if (day % 7 == 0) return "SUN";
            else if (day % 7 == 1) {
                return "MON";
            } else if (day % 7 == 2) {
                return "TUE";
            } else if (day % 7 == 3) {
                return "WED";
            }else if (day % 7 == 4) {
                return "THU";
            }else if (day % 7 == 5) {
                return "FRI";
            }else {
                return "SAT";
            }
        } else {
            if (day == 1) return "MON";
            if (day == 2) return "TUE";
            if (day == 3) return "WED";
            if (day == 4) return "THU";
            if (day == 5) return "FRI";
            else  return "SAT";
        }
    }

    private static String startTuesday(int day) {
        if (day >= 7){
            if (day % 7 == 0) return "MON";
            else if (day % 7 == 1) {
                return "TUE";
            } else if (day % 7 == 2) {
                return "WED";
            } else if (day % 7 == 3) {
                return "THU";
            }else if (day % 7 == 4) {
                return "FRI";
            }else if (day % 7 == 5) {
                return "SAT";
            }else {
                return "SUN";
            }
        } else {
            if (day == 1) return "TUE";
            if (day == 2) return "WED";
            if (day == 3) return "THU";
            if (day == 4) return "FRI";
            if (day == 5) return "SAT";
            else  return "SUN";
        }
    }private static String startWendsday(int day) {
        if (day >= 7){
            if (day % 7 == 0) return "TUE";
            else if (day % 7 == 1) {
                return "WED";
            } else if (day % 7 == 2) {
                return "THU";
            } else if (day % 7 == 3) {
                return "FRI";
            }else if (day % 7 == 4) {
                return "SAT";
            }else if (day % 7 == 5) {
                return "SUN";
            }else {
                return "MON";
            }
        } else {
            if (day == 1) return "WED";
            if (day == 2) return "THU";
            if (day == 3) return "FRI";
            if (day == 4) return "SAT";
            if (day == 5) return "SUN";
            else  return "MON";
        }
    }private static String startThursday(int day) {
        if (day >= 7){
            if (day % 7 == 0) return "WED";
            else if (day % 7 == 1) {
                return "THU";
            } else if (day % 7 == 2) {
                return "FRI";
            } else if (day % 7 == 3) {
                return "SAT";
            }else if (day % 7 == 4) {
                return "SUN";
            }else if (day % 7 == 5) {
                return "MON";
            }else {
                return "TUE";
            }
        } else {
            if (day == 1) return "THU";
            if (day == 2) return "FRI";
            if (day == 3) return "SAT";
            if (day == 4) return "SUN";
            if (day == 5) return "MON";
            else  return "TUE";
        }
    }private static String startFriday(int day) {
        if (day >= 7){
            if (day % 7 == 0) return "THU";
            else if (day % 7 == 1) {
                return "FRI";
            } else if (day % 7 == 2) {
                return "SAT";
            } else if (day % 7 == 3) {
                return "SUN";
            }else if (day % 7 == 4) {
                return "MON";
            }else if (day % 7 == 5) {
                return "TUE";
            }else {
                return "WED";
            }
        } else {
            if (day == 1) return "FRI";
            if (day == 2) return "SAT";
            if (day == 3) return "SUN";
            if (day == 4) return "MON";
            if (day == 5) return "TUE";
            else  return "WED";
        }
    }private static String startSaturday(int day) {
        if (day >= 7){
            if (day % 7 == 0) return "FRI";
            else if (day % 7 == 1) {
                return "SAT";
            } else if (day % 7 == 2) {
                return "SUN";
            } else if (day % 7 == 3) {
                return "MON";
            }else if (day % 7 == 4) {
                return "TUE";
            }else if (day % 7 == 5) {
                return "WED";
            }else {
                return "THU";
            }
        } else {
            if (day == 1) return "SAT";
            if (day == 2) return "SUN";
            if (day == 3) return "MON";
            if (day == 4) return "TUE";
            if (day == 5) return "WED";
            else  return "THU";
        }
    }
    private static String startSunday(int day) {
        if (day >= 7) {
            if (day % 7 == 0) return "SAT";
            else if (day % 7 == 1) {
                return "SUN";
            } else if (day % 7 == 2) {
                return "MON";
            } else if (day % 7 == 3) {
                return "TUE";
            } else if (day % 7 == 4) {
                return "WED";
            } else if (day % 7 == 5) {
                return "THU";
            } else {
                return "FRI";
            }
        } else {
            if (day == 1) return "SUN";
            if (day == 2) return "MON";
            if (day == 3) return "TUE";
            if (day == 4) return "WED";
            if (day == 5) return "THU";
            else return "FRI";
        }
    }

}
