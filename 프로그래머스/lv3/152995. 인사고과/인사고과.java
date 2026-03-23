import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        int wanhoScore = wanho[0] + wanho[1];

        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int max = 0;
        for (int[] s : scores) {
            if (s[1] < max) {
                if (s.equals(wanho)) return -1;
            }
            else if (s[0] + s[1] > wanhoScore) {
                answer++;
                max = Math.max(max, s[1]);
            }
        }

        return answer + 1;
    }
}