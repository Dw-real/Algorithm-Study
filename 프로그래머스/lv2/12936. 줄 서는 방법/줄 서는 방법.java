class Solution {
    public int[] solution(int n, long k) {
        int[] arr = new int[n + 1];
        long[] fact = new long[21];
        boolean[] visited = new boolean[21];

        fact[0] = 1;
        for (int i=1; i<=n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        for (int i=1; i<=n; i++) {
            int cnt = 1;
            for (int j=1; j<=n; j++) {
                if (visited[j]) continue;

                if (k <= fact[n - i] * cnt) {
                    k -= (fact[n - i] * (cnt - 1));
                    arr[i] = j;
                    visited[j] = true;
                    break;
                }
                cnt++;
            }
        }
        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            answer[i] = arr[i + 1];
        }
        return answer;
    }
}