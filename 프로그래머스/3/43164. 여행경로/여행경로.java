import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> list;

    static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        tripPath(new StringBuilder("ICN"), "ICN", tickets, 0);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    static void tripPath(StringBuilder sb, String city, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            int len = sb.length();
            if (!visited[i] && from.equals(city)) {
                visited[i] = true;
                sb.append(" ").append(to);
                tripPath(sb, to, tickets, depth + 1);
                sb.setLength(len);
                visited[i] = false;
            }
        }
    }
}