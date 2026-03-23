class Solution {
    static int[][] dp;
    static int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];

        // 물 웅덩이가 있는 곳은 지나갈 수 없음
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i][1] == -1)
                break;
            dp[i][1] = 1;
        }

        for (int i = 2; i <= m; i++) {
            if (dp[1][i] == -1)
                break;
            dp[1][i] = 1;
        }
        
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (dp[i][j] == -1)
                    continue;
                if (dp[i][j - 1] == -1) { // 오른쪽으로 갈 수 없는 경우
                    dp[i][j] = dp[i - 1][j] % MOD;
                } else if (dp[i - 1][j] == -1) { // 아래로 갈 수 없는 경우
                    dp[i][j] = dp[i][j - 1] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
                }
            }
        }
        return dp[n][m] % MOD;
    }
}