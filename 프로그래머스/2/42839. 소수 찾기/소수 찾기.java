import java.util.*;

class Solution {
    static HashSet<Integer> answer;
    static boolean[] visited;

    public int solution(String numbers) {
        answer = new HashSet<>();
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(new StringBuilder(), numbers, visited, i, 0);
        }

        return answer.size();
    }

    public void dfs(StringBuilder sb, String numbers, boolean[] visited, int len, int depth) {
        if (depth == len) {
            int num = Integer.parseInt(sb.toString());
            if (isPrime(num))
                answer.add(num);
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                dfs(sb, numbers, visited, len, depth + 1);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}