import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer size1, Integer size2) {
                return map.get(size2) - map.get(size1);
            }
        });

        int answer = 0;
        for (Integer size : list) {
             k -= map.get(size);
             answer++;

             if (k <= 0)
                break;
        }

        return answer;
    }
}