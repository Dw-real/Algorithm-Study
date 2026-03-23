class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (n < 3) {
                sb.append(n);
                break;
            }
            sb.append(n % 3);
            n /= 3;
        }

        int answer = 0;
        int start = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int num = sb.charAt(i) - '0';
            answer += (num * Math.pow(3, start));
            start++;
        }

        return answer;
    }
}