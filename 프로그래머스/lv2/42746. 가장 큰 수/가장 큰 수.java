import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int len = numbers.length;
        String[] nums = new String[len];

        for (int i = 0; i < len; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        if (nums[0].equals("0"))
            return "0";

        for (String s : nums) {
            sb.append(s);
        }

        return sb.toString();
    }
}