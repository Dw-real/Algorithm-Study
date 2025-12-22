class Solution {
    public int solution(int[] money) {
        int length = money.length;
        int[] dp = new int[length]; // 첫 번째 집을 선택한 경우
        int[] dp2 = new int[length]; // 첫 번째 집을 선택하지 않은 경우

        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        return Math.max(dp[length - 2], dp2[length - 1]);
    }
}