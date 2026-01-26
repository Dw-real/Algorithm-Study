import java.util.*;

class Solution {
    static boolean[] visited;
    static PriorityQueue<Integer> group;

    public int solution(int[] cards) {
        int n = cards.length;
        visited = new boolean[n];
        group = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(cards[i], cards, 0);
            }
        }

        if (group.size() <= 1)
            return 0;
        else {
            int a = group.poll();
            int b = group.poll();
            return a * b;
        }
    }

    public void dfs(int idx, int[] cards, int count) {
        if (visited[idx - 1]) {
            group.add(count);
            return;
        }
        visited[idx - 1] = true;
        dfs(cards[idx - 1], cards, count + 1);
    }
}