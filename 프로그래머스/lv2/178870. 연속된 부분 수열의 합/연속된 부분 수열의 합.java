import java.util.*;

class Solution {
     public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 0;
    
        int minLength = 1000001;
        int minS = 0;
        int minE = 0;
        int sum = sequence[0];

        while (e < sequence.length) {
            if (sum == k) {
                if (e - s + 1 < minLength) {
                    minLength = e - s + 1;
                    minS = s;
                    minE = e;
                }
                e++;
                if (e < sequence.length)
                    sum += sequence[e];
            }
            else if (sum > k) {
                sum -= sequence[s];
                s++;
            }
            else {
                e++;  
                if (e < sequence.length)
                    sum += sequence[e];
            }
        }

        int[] answer = new int[2];
        answer[0] = minS;
        answer[1] = minE;

        return answer;
    }

}