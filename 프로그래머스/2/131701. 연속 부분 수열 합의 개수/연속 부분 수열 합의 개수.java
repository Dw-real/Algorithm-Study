import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] circleArr = new int[elements.length * 2 - 1];
        int[] sum = new int[elements.length * 2];
        sum[1] = circleArr[0];
        for (int i = 0; i < elements.length; i++) {
            circleArr[i] = elements[i];
        }
        for (int i = elements.length; i < circleArr.length; i++) {
            circleArr[i] = elements[i % elements.length];
        }
        for (int i = 2; i < sum.length; i++) {
            sum[i] = circleArr[i - 1] + sum[i - 1];
        }
        for (int i = 1; i <= elements.length; i++) {
            for (int j = circleArr.length; j >= 1; j--) {
                if (j - i <= 0) continue;
                set.add(sum[j] - sum[j - i]);
            }
        }
        return set.size();
    }
}