import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int n : queue1) {
            sum1 += n;
            q1.add(n);
        }
        for (int n : queue2) {
            sum2 += n;
            q2.add(n);
        }

        if (sum1 == sum2) 
            return 0;
        
        if ((sum1 + sum2) % 2 == 1)
            return -1;

        int count = 0;
        int max = queue1.length * 6;

        while (true) {
            if (sum1 > sum2) {
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.add(q1.poll());
            }
            else {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
            }
            
            count++;

            if (count > max) return -1;
            
            if (sum1 == sum2)
                break;
        }
        return count;
    }
}