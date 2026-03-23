class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int x = 0;

        while (x * k <= d) {
            int y = getY(d, x * k);
            answer += y / k;
            answer += 1;
            x++;
        }
        return answer;
    }

    static int getY(int d, int x) {
        return (int)(Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2)));
    }
}