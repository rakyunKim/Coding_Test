package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number2309 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> dwarf = new ArrayList<>();

        int totalDwarfWeight = 0;
        for(int i = 0; i < 9; i++){
            dwarf.add(scanner.nextInt());
            totalDwarfWeight += dwarf.get(i);
        }
        Collections.sort(dwarf);

        int targetWeight = totalDwarfWeight - 100;
        int ignoreNumber1 = 0;
        int ignoreNumber2 = 0;
        for(int i = 0; i < 9; i++){
            if(ignoreNumber1 != 0 && ignoreNumber2 != 0){
                break;
            }
            for(int j = 1; j < 9; j++){
                if(i != j){
                    if(dwarf.get(i) + dwarf.get(j) == targetWeight){
                        ignoreNumber1 = dwarf.get(i);
                        ignoreNumber2 = dwarf.get(j);
                        break;
                    }
                }
            }
        }

        for(int i : dwarf){
            if(i != ignoreNumber1 && i != ignoreNumber2){
                System.out.println(i);
            }
        }
    }
}
