import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        HashSet<Integer> monsters = new HashSet<>();
        
        for (int num : nums) {
            monsters.add(num);
        }
        
        if (monsters.size() >= n / 2) {
            return n / 2;
        } else {
            return monsters.size();
        }
    }
}