import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> list;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        StringBuilder sb = new StringBuilder("ICN");
        dfs(sb, "ICN", 0, tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public void dfs(StringBuilder sb, String city, int depth, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];

            if (!visited[i] && start.equals(city)) {
                int originalLen = sb.length();
                sb.append(" ").append(end);
                visited[i] = true;
                dfs(sb, end, depth + 1, tickets);
                sb.setLength(originalLen);
                visited[i] = false;
            }
        }
    }

}