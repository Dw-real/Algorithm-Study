import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        int answer = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            boolean flag = false;

            // 큐에 현재 프로세스보다 우선순위가 높은 프로세스가 존재하는 경우
            for (int[] process : q) {
                if (process[1] > now[1]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                q.add(now);
            } else {
                answer++;

                if (now[0] == location)
                    return answer;
            }
        }

        return answer;
    }
}