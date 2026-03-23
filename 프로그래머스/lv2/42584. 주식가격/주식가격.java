import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        for (int price : prices) {
            q.add(price);
        }
        Queue<Integer> t = new LinkedList<>(); // 가격이 떨어지지 않은 기간을 담을 큐

        while (!q.isEmpty()) {
            int now = q.poll();
            int time = 0;

            for (int p : q) {
                time++;
                if (p < now) {
                    break;
                }
            }
            t.add(time);
        }

        return t.stream().mapToInt(Integer::intValue).toArray();
    }
}