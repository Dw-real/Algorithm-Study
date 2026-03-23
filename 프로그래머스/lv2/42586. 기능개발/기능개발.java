import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>(); // 작업이 끝날 때까지 걸리는 기간
        Queue<Integer> q = new LinkedList<>(); // 각 배포마다 배포되는 기능 수

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                list.add((100 - progresses[i]) / speeds[i]);
            } else {
                list.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int day = list.get(0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= day)
                count++;
            else {
                q.add(count);
                day = list.get(i);
                count = 1;
            }
        }
        q.add(count);
        
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}