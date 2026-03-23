import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int server = 0; // 현재 운영 중인 서버

        for (int i = 0; i < players.length; i++) {
            int need = players[i] / m; // 필요한 서버 수

            while (!q.isEmpty() && q.peek()[1] <= i) {
                server -= q.poll()[0];
            }

            int add = Math.max(0, need - server);

            answer += add;
            server += add;

            q.add(new int[]{add, i + k});
        }
        
        return answer;
    }
}