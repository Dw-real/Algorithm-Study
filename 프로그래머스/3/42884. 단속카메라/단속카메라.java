import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.addAll(Arrays.asList(routes));

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            while (true) {
                if (!pq.isEmpty() && pq.peek()[0] <= now[1]) {
                    pq.poll();
                } else {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}