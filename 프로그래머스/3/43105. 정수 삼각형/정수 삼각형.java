class Solution {
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int length = triangle.length;
        dp = new int[length][length];

        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];

        for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[length - 1][i]);
        }
        return answer;
    }
}