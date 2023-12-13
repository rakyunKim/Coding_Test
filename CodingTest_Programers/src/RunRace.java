import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RunRace {
	public static void main(String[] args) {
		String[] players = new String[]{"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = new String[]{"kai", "kai", "mine", "mine"};
		Map<String, Player> playerMap = makePlayerList(players);
		for (String calling : callings){
			finishRace(playerMap, calling);
		}
		String[] answer = setUpAnswer(playerMap);
		System.out.println(Arrays.toString(answer));
	}

	private static void finishRace(Map<String, Player> playerMap, String calling) {
		int currentRank = playerMap.get(calling).getCurrentRank() - 1;
		findPlayerDownRank(currentRank, playerMap);
		playerMap.get(calling).movedUpRank();
	}

	private static void findPlayerDownRank(int currentRank, Map<String, Player> playerMap) {
		for (Player player : playerMap.values()){
			if (player.getCurrentRank() == currentRank){
				player.movedDownRank();
				break;
			}
		}
	}

	private static String[] setUpAnswer(Map<String, Player> playerMap) {
		String[] answer = new String[playerMap.size()];
		for (Player player : playerMap.values()) {
			int currentRank = player.getCurrentRank();
			answer[currentRank - 1] = player.getName();
		}
		return answer;
	}

	private static Map<String, Player> makePlayerList(String[] players) {
		Map<String, Player> playerMap = new HashMap<>();
		for (int i = 0; i < players.length; i++){
			playerMap.put(players[i], new Player(players[i], i + 1));
		}
		return playerMap;
	}

	public static class Player{
		String name;
		int currentRank;
		public Player(String name, int currentRank){
			this.name = name;
			this.currentRank = currentRank;
		}
		public void movedUpRank(){
			currentRank--;
		}
		public void movedDownRank(){
			currentRank++;
		}
		public int getCurrentRank(){
			return currentRank;
		}
		public String getName(){
			return name;
		}
	}

}
