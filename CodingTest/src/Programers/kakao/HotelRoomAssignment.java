package Programers.kakao;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class HotelRoomAssignment {
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        long k = 1000000000;
        long[] room_number = new long[]{1,3,4,1,3,1};

        long[] result = solution(k, room_number);

        System.out.println(Arrays.toString(result));
    }
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i = 0; i < room_number.length; i++){
            answer[i] = findEmptyRood(room_number[i]);
        }
        return answer;
    }

    public static long findEmptyRood(long request){
        if(!map.containsKey(request)){
            map.put(request, request+1);
            return request;
        }

        long next_room = map.get(request);
        long empty_room = findEmptyRood(next_room);
        map.put(request, empty_room);
        return empty_room;
    }
}
