import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> items = new HashMap<>();

        for (int i = 0; i <= discount.length - 10; i++) {
            boolean valid = true;
            for (int j = i; j < i + 10; j++) {
                items.put(discount[j], items.getOrDefault(discount[j], 0) + 1);
            }
            
            for (int j = 0; j < want.length; j++) {
                if (items.getOrDefault(want[j], 0) < number[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                answer++;

            items.clear();
        }
        
        return answer;
    }
}