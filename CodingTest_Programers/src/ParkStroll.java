
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ParkStroll {
	static List<String> parkList = new ArrayList<>();
	public static void main(String[] args) {
//		String[] park = new String[]{"SOO","OOO","OOO"};
//		String[] routes = new String[]{"E 2","S 2","W 1"};

		String[] park = new String[]{"0000S00", "00XX000", "0000000", "00XX000", "00XX000", "0000000", "XXXX000", "XXXX000", "000XXX0", "0000000", "X00X00X"};
		String[] routes = new String[]{"E 2","S 3","W 2", "N 1", "W 4", "S 4", "S 3", "E 7", "E 6", "S 2", "W 4", "S 2", "W 6", "S 1"};
		solution(park, routes);
	}
	public static int[] solution(String[] park, String[] routes) {
		int sx = 0;
		int sy = 0;

		char[][] arr = new char[park.length][park[0].length()];

		for(int i = 0; i < park.length; i++){
			arr[i] = park[i].toCharArray();

			if(park[i].contains("S")){
				sy = i;
				sx = park[i].indexOf("S");
			}
		}

		for(String st : routes){
			String way = st.split(" ")[0];
			int len = Integer.parseInt(st.split(" ")[1]);

			int nx = sx;
			int ny = sy;

			for(int i = 0; i < len; i++){
				if(way.equals("E")){
					nx++;
				}
				if(way.equals("W")){
					nx--;
				}
				if(way.equals("S")){
					ny++;
				}
				if(way.equals("N")){
					ny--;
				}
				if(nx >=0 && ny >=0 && ny < arr.length && nx < arr[0].length){
					if(arr[ny][nx] == 'X'){
						break;
					}
					// 범위내 & 장애물 x
					if(i == len-1){
						sx = nx;
						sy = ny;
					}
				}
			}
		}

		int[] answer = {sy, sx};
		return answer;
	}

}