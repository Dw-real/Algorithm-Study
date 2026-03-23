import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            if (list.size() >= 4) {
                if (list.get(list.size() - 4) == 1 && list.get(list.size() - 3) == 2 && list.get(list.size() - 2) == 3 && list.get(list.size() - 1) == 1) {
                    answer++;
                    list.remove(list.size() - 4);
                    list.remove(list.size() - 3);
                    list.remove(list.size() - 2);
                    list.remove(list.size() - 1);
                }
            }
        }
        return answer;
    }
}