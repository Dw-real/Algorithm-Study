import java.util.*;

class Solution {
    static HashSet<String> banList;
    static boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        banList = new HashSet<>();
        visited = new boolean[user_id.length];

        HashSet<String> banned = new HashSet<>();

        dfs(user_id, banned_id, banned, 0);

        return banList.size();
    }

    public void dfs(String[] user_id, String[] banned_id, HashSet<String> banned, int depth) {
        if (depth == banned_id.length) {
            ArrayList<String> list = new ArrayList<>(banned);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (String id : list) {
                sb.append(id);
            }
            banList.add(sb.toString());
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && isPossible(user_id[i], banned_id[depth])) {
                visited[i] = true;
                banned.add(user_id[i]);
                dfs(user_id, banned_id, banned, depth + 1);
                banned.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }

    public boolean isPossible(String id, String sanctionId) {
        if (id.length() != sanctionId.length()) {
            return false;
        } else {
            for (int i = 0; i < sanctionId.length(); i++) {
                if (sanctionId.charAt(i) == '*') continue;
                if (sanctionId.charAt(i) != id.charAt(i))
                    return false;
            }

            return true;
        }
    }
}