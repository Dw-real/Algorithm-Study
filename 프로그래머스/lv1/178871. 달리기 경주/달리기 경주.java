import java.util.*;

class Solution {
    public void swap(String[] s, int i, int j){
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> rank = new HashMap<>();

        int r = 0;
        for (String player : players) {
            rank.put(player, r);
            r++;
        }

        for (String calling : callings) {
            int idx = rank.get(calling);
            swap(players, idx, idx - 1);

            rank.put(players[idx - 1], rank.get(calling) - 1);
            rank.put(players[idx], rank.get(players[idx - 1]) + 1);
        }
        return players;
    }
}