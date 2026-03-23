import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        for (String city : cities) {
            city = city.toUpperCase();
            int index  = cache.indexOf(city);

            if (index >= 0) {
                cache.remove(index);
                cache.add(city);
                answer += 1;
            }
            else {
                cache.add(city);
                answer += 5;
            }

            if (cache.size() > cacheSize) {
                cache.remove(0);
            }
        }
        return answer;
    }
}