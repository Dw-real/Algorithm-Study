import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i <= citations.length; i++) {
            int up = 0;
            int down = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i)
                    up++;
                else
                    down++;
            }
            if (up >= i && down <= i) {
                answer = i;
            }
        }
        return answer;
    }
}