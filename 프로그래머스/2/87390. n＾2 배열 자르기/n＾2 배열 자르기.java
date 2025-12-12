class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);

        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = Math.max((int)((i + left) / n + 1), (int)((i + left) % n + 1));
        }
        return answer;
    }
}