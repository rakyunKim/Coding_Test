package Programers.kakao;

import java.io.IOException;
import java.util.Stack;

public class TableEditing {
    public static void main(String[] args) throws IOException {
        int n = 8;
        int k = 2;

        String[] cmd = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
//        String[] cmd = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(solution(n, k, cmd));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove_order = new Stack<>();
        int table_size = n;
        for(int i=0; i<cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            }
            else if(c == 'U') {
                k -= Integer.parseInt(cmd[i].substring(2));
            }
            else if(c == 'C') {
                remove_order.add(k);
                table_size--;
                if(k == table_size)
                    k--;
            }
            else if(c == 'Z') {
                if(remove_order.pop()<=k)
                    k++;
                table_size++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("O".repeat(Math.max(0, table_size)));

        while(!remove_order.isEmpty())
            builder.insert(remove_order.pop(), "X");

        return builder.toString();
    }
}
