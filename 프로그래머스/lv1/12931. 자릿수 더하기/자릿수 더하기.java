import java.util.*;

public class Solution {
    public int solution(int n) {
        String num = String.valueOf(n);
        int answer = 0;

        for (int i=0; i<num.length(); i++) {
            answer += num.charAt(i) - '0';
        }

        return answer;
    }
}