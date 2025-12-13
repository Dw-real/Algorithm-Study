import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> comp = new HashMap<>();

        for (String name : participant) {
            comp.put(name, comp.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            comp.put(name, comp.get(name) - 1);
        }
        for (Map.Entry<String, Integer> entry : comp.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}