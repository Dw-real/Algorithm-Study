class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int num, int idx, int target) {
        if (idx == numbers.length) {
            if (num == target)
                answer++;
            return;
        }
        dfs(numbers, num + numbers[idx], idx + 1, target);
        dfs(numbers, num - numbers[idx], idx + 1, target);
    }
}