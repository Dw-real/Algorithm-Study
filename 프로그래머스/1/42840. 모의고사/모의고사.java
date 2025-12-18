import java.util.*;

class Solution {
    static int[] one = {1, 2, 3, 4, 5};
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length])
                oneCount++;
            if (answers[i] == two[i % two.length])
                twoCount++;
            if (answers[i] == three[i % three.length])
                threeCount++;
        }

        int max = Math.max(oneCount, Math.max(twoCount, threeCount));
        if (max == oneCount)
            answer.add(1);
        if (max == twoCount)
            answer.add(2);
        if (max == threeCount)
            answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}