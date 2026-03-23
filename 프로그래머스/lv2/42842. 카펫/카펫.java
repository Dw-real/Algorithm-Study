class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        for (int w = 3; w <= sum; w++) {
            if (sum % w != 0) continue;
            int h = sum / w;
            int y = (w - 2) * (h - 2);
            if (w >= h && y == yellow && sum - y == brown) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }

        return answer;
    }
}