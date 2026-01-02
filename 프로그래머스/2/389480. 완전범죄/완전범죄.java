class Solution {
    static int answer;
    static boolean[][][] visited;

    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[info.length][n][m];
        dfs(info, n, m, 0, 0, 0);

        if (answer == Integer.MAX_VALUE)
            return -1;
        else
            return answer;
    }

    public void dfs(int[][] info, int n, int m, int idx, int a, int b) {
        if (a >= n || b >= m)
            return;

        if (idx == info.length) {
            answer = Math.min(answer, a);
            return;
        }
        if (visited[idx][a][b])
            return;
        visited[idx][a][b] = true;
        
        dfs(info, n, m, idx + 1, a + info[idx][0], b);
        dfs(info, n, m, idx + 1, a, b  + info[idx][1]);
    }
}