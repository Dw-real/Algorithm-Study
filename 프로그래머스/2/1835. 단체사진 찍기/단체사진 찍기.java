import java.util.*;

class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited;
    static int answer;

    public int solution(int n, String[] data) {
        visited = new boolean[8];
        answer = 0;
        dfs(new ArrayList<>(), n, data, 0);
        return answer;
    }

    public void dfs(ArrayList<Character> output, int n, String[] data, int depth) {
        if (depth == 8) {
            if (check(output, data)) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.add(friends[i]);
                dfs(output, n, data, depth + 1);
                output.remove(output.size() - 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(ArrayList<Character> output, String[] data) {
        for (String d : data) {
            char f1 = d.charAt(0);
            char f2 = d.charAt(2);
            char c = d.charAt(3);
            int interval = d.charAt(4) - '0';

            int idx1 = output.indexOf(f1);
            int idx2 = output.indexOf(f2);

            int i = Math.abs(idx1 - idx2) - 1;

            switch (c) {
                case '=':
                    if (i != interval)
                        return false;
                    break;
                case '>':
                    if (i <= interval)
                        return false;
                    break;
                case '<':
                    if (i >= interval)
                        return false;
                    break;
            }
        }
        return true;
    }
}