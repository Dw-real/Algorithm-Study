import java.util.*;

class Solution {
    public int solution(int[] topping) {
            HashMap<Integer, Integer> c = new HashMap<>(); // 철수의 롤케이크에 올려진 토핑의 종류
            HashMap<Integer, Integer> b = new HashMap<>(); // 동생의 롤케이크에 올려진 토핑의 종류

            for (int t : topping) {
                c.put(t, c.getOrDefault(t, 0) + 1);
            }

            int answer = 0;

            // 롤케이크 나누기
            for (int t : topping) {
                b.put(t, b.getOrDefault(t, 0) + 1);
                c.put(t, c.getOrDefault(t, 0) - 1);
                if (c.get(t) <= 0) { // 철수의 롤케이크에 해당 토핑이 빠지는 경우
                    c.remove(t);
                }

                if (c.size() == b.size()) {
                    answer++;
                }
            }

            return answer;
    }

}