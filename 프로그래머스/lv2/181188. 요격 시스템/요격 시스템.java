import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // 폭격 미사일의 끝 지점을 기준으로 오름차순 정렬
        PriorityQueue<int[]> missile = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        missile.addAll(Arrays.asList(targets));

        while (!missile.isEmpty()) {
            int[] m = missile.poll();

            while (true) {
                if (!missile.isEmpty() && missile.peek()[0] < m[1]) {
                    missile.poll();
                } else{
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}