class Solution {
    static int[] dp;
    static int MOD = 1234567;
    
    public int solution(int n) {
        setArray();
        int answer = fibonacci(n);
        return answer;
    }
    
    public void setArray() {
        dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=100000; i++)
            dp[i] = -1;
    }
    
    public int fibonacci(int n) {
        if (dp[n] != -1)
            return dp[n] % MOD;
        else
            return dp[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % MOD;
    }
}