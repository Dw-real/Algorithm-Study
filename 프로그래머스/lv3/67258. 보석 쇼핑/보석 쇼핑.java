import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> type = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> section = new HashMap<>();

        int start = 0;
        int end = 0;

        section.put(gems[end], 1);
        
        int s = 100001;
        int e = Integer.MAX_VALUE;

        while (true) {
            if (section.size() == type.size()) { // 해당 구간에 모든 종류에 보석이 있는 경우
                if (e - s > end - start) { // 기존 구간 보다 짧은 경우 (같은 경우는 시작 진열대가 작은 구간이기 때문에 같은 경우는 고려 X
                    s = start;
                    e = end;
                }
                section.put(gems[start], section.getOrDefault(gems[start], 0) - 1);
                if (section.get(gems[start]) <= 0)
                    section.remove(gems[start]);

                start++;
            } else if (section.size() < type.size()) { // 모든 종류의 보석을 가지고 있지 못한 경우
                if (end == gems.length - 1) break;
                end++;
                section.put(gems[end], section.getOrDefault(gems[end], 0) + 1);
            }
        }

        answer[0] = s + 1;
        answer[1] = e + 1;

        return answer;
    }
}