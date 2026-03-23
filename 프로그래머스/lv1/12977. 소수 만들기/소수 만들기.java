class Solution {
    static int answer = 0;

    public int solution(int[] nums) {
        combination(nums, new int[3], new boolean[nums.length], 0, 0);
        return answer;
    }

    public void combination(int[] nums, int[] output, boolean[] visited, int start, int depth) {
        if (depth == 3) {
            if (isPrime(output))
                answer++;
            return;
        }
        for (int i=start; i<nums.length; i++) {
            visited[i] = true;
            output[depth] = nums[i];
            combination(nums, output, visited, i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public boolean isPrime(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        for (int i=2; i<=Math.sqrt(sum); i++) {
            if (sum % i == 0)
                return false;
        }
        return true;
    }
}