package Baekjoon.소마코테준비;
import java.util.*;
import java.io.*;
public class Number1043 {
    static int[] parent;
    static List<Integer> knowTruth;
    static List<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int personCount = Integer.parseInt(st.nextToken());
        int partyCount = Integer.parseInt(st.nextToken());

        parent = new int[personCount + 1];
        for(int i = 1; i <= personCount; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(bf.readLine());
        int knowTruthCount = Integer.parseInt(st.nextToken());
        knowTruth = new ArrayList<>();
        for(int i = 0; i < knowTruthCount; i++){
            knowTruth.add(Integer.parseInt(st.nextToken()));
        }

        party = new ArrayList[partyCount];
        for(int i = 0; i < partyCount; i++){
            party[i] = new ArrayList<>();
        }
        for(int i = 0; i < partyCount; i++){
            st = new StringTokenizer(bf.readLine());
            int partyJoinMemberCount = Integer.parseInt(st.nextToken());
            if(partyJoinMemberCount > 1){
                int joinMember = Integer.parseInt(st.nextToken());
                party[i].add(joinMember);
                for(int j = 1; j < partyJoinMemberCount; j++){
                    int nextJoinMember = Integer.parseInt(st.nextToken());
                    union(joinMember, nextJoinMember);
                    party[i].add(nextJoinMember);
                }
            } else{
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        boolean isContains;
        int count = 0;
        for(int i = 0; i < partyCount; i++){
            isContains = false;
            for(int j : party[i]){
                int check = find(j);
                if(knowTruth.contains(check)){
                    isContains = true;
                    break;
                }
            }
            if(!isContains){
                count++;
            }
        }

        System.out.println(count);


    }

    private static int find(int member) {
        if(parent[member] == member) return member;
        else{
            return parent[member] = find(parent[member]);
        }
    }

    private static void union(int member1, int member2) {
        int parent1 = find(member1);
        int parent2 = find(member2);
        if(knowTruth.contains(parent1)){
            parent[parent2] = parent1;
        }
        else if(knowTruth.contains(parent2)){
            parent[parent1] = parent2;
        } else{
            if(parent1 < parent2){
                parent[parent2] = parent1;
            } else{
                parent[parent1] = parent2;
            }
        }
    }
}
