class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dir = {'d', 'l', 'r', 'u'};

    static String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();

        return dfs(n, m, x, y, r, c, k, sb);
    }

    static String dfs(int n, int m, int x, int y, int r, int c, int k, StringBuilder sb) {
        if (sb.length() == k) {
            if (x == r && y == c)
                return sb.toString();
        }
        int remain = k - sb.length();
        int dist = Math.abs(r - x) + Math.abs(c - y);

        // 도착지까지 갈 수 없거나 남은 이동 횟수보다 거리가 더 많은 경우
        if (remain < dist || (remain - dist) % 2 != 0) return "impossible";

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;

            sb.append(dir[i]);
            String result = dfs(n, m, nx, ny, r, c, k, sb);
            sb.deleteCharAt(sb.length() - 1);

            if (!result.equals("impossible"))
                return result;
        }

        return "impossible";
    }
}