import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int m = 0; // 무적권 사용 횟수

        for (int e : enemy) {
            pq.add(e);
            m++;

            if (m > k) {
                n -= pq.poll();
                m--;
                if (n < 0)
                    break;
            }
            answer++;
        }
        return answer;
    }
}