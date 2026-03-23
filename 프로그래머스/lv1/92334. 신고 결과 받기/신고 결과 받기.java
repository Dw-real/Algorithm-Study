import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> count = new HashMap<>(); // 각 유저가 신고당한 횟수
        HashMap<String, Integer> idx = new HashMap<>(); // 각 유저에 해당하는 id_list의 인덱스
        HashMap<String, HashSet<String>> log = new HashMap<>(); // 각 유저가 신고한 유저
        HashSet<String> l = new HashSet<>();

        for (int i = 0; i < id_list.length; i++) {
            idx.put(id_list[i], i);
        }

        for (String s : report) {
            if (l.contains(s))
                continue;
            l.add(s);
            String a = s.split(" ")[0];
            String b = s.split(" ")[1];

            count.put(b, count.getOrDefault(b, 0) + 1);
            HashSet<String> reportLog = log.getOrDefault(a, new HashSet<>());
            reportLog.add(b);
            log.put(a, reportLog);
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String id = entry.getKey();
            if (entry.getValue() >= k) {
                for (Map.Entry<String, HashSet<String>> entry2 : log.entrySet()) {
                    String reporter = entry2.getKey();
                    if (entry2.getValue().contains(id)) {
                        int index = idx.get(reporter);
                        answer[index]++;
                    }
                }
            }
        }
        return answer;
    }
}