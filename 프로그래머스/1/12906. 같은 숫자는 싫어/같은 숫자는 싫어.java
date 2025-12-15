import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int n : arr) {
            if (!stack.isEmpty()) {
                if (n == stack.peek())
                    stack.pop();
            }
            stack.push(n);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}