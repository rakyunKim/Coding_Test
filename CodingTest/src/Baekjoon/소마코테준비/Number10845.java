package Baekjoon.소마코테준비;
import java.util.*;
import java.io.*;

public class Number10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();
        int operationCount = Integer.parseInt(bf.readLine());

        for(int i = 0; i < operationCount; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String operation = st.nextToken();
            if(operation.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            } else if(operation.equals("pop")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                } else{
                    System.out.println(queue.poll());
                }
            } else if(operation.equals("front")){
                if(queue.peek() == null){
                    System.out.println(-1);
                }
                else{
                    System.out.println(queue.peek());
                }
            } else if(operation.equals("back")){
                if(queue.isEmpty()) System.out.println(-1);
                else{
                    int lastNum = ((LinkedList<Integer>) queue).getLast();
                    System.out.println(lastNum);
                }
            } else if(operation.equals("size")){
                System.out.println(queue.size());
            } else if(operation.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
            }
        }
    }
}
