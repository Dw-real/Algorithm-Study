import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int num = 1; // 컨베이어벨트에는 1,2,3,4,5......order.length 순서로 상자가 있음
        for (int i=0; i<order.length; i++) {
            for (int j=num; j<order[i]; j++) {
                stack.push(num);
                num++;
            }
            if (num == order[i]) {
                answer++;
                num++;
            }
            else if (!stack.isEmpty() && stack.peek() == order[i]) {
                answer++;
                stack.pop();
            } else {
                break;
            }
        }

        return answer;
    }
}