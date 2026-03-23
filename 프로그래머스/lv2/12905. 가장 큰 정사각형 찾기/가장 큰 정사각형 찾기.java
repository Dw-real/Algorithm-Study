class Solution
{
    public int solution(int[][] board) {

        int[][] dp = new int[board.length + 1][board[0].length + 1];

        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[i - 1].length; j++) {
                dp[i][j] = board[i - 1][j - 1];
            }
        }

        int answer = 0;
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[i - 1].length; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = getMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }

    public int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}