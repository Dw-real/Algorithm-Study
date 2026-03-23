import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> work = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i=0; i<works.length; i++) {
            work.add(works[i]);
        }
        long ans = 0;
        while (true) {
            int max = work.poll();

            if (max == 0)
                break;

            work.add(max - 1);
            n--;

            if (n == 0)
                break;
        }

        for (int w : work) {
            ans += Math.pow(w, 2);
        }

        return ans;
    }
}