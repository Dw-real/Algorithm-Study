import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> closet = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            closet.put(type, closet.getOrDefault(type, 0) + 1);
        }

        int combi = 1;
        for (int count : closet.values()) {
            combi *= (count + 1);
        }
        
        return combi - 1;
    }
}