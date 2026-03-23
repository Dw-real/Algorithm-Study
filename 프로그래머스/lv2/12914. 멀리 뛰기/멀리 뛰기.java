class Solution {
    static int mod = 1234567;
    static long[] dp = new long[2001];

    public long solution(int n) {
        dp[1] = 1; // 1
        dp[2] = 2; // 1 + 1, 2

        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return dp[n];
    }
}