import java.util.*;

class Solution {
    static int MUL = 65536;
    public int solution(String str1, String str2) {
        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();
        int ans = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i=0; i<str1.length() - 1; i++) {
            String key = "";
            key += str1.charAt(i);
            key += str1.charAt(i + 1);

            if (key.matches("^[a-z]+$")) {
                str1Map.put(key, str1Map.getOrDefault(key, 0) + 1);
            }
        }

        for (int i=0; i<str2.length() - 1; i++) {
            String key = "";
            key += str2.charAt(i);
            key += str2.charAt(i + 1);

            if (key.matches("^[a-z]+$")) {
                str2Map.put(key, str2Map.getOrDefault(key, 0) + 1);
            }
        }

        int sub = 0;
        HashMap<String, Integer> sumMap = new HashMap<>(str2Map); // 합집합
        for (String s : str1Map.keySet()) {
            if (str2Map.containsKey(s)) {
                sub += Math.min(str1Map.get(s), str2Map.get(s));
                sumMap.put(s, Math.max(str1Map.get(s), str2Map.get(s)));
            } else {
                sumMap.put(s, str1Map.get(s));
            }
        }
        int sum = 0;
        for (int count : sumMap.values()) {
            sum += count;
        }
        if (sum == 0)
            ans = MUL;
        else
            ans = (sub * MUL) / sum;

        return ans;
    }
}