class Solution {
    public int solution(String name) {
        int upDown = 0; // 상하 최소 움직임
        int leftRight = name.length() - 1; // 좌우 최소 움직임

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            upDown += Math.min(c - 'A', 'Z' - c + 1); // 위로 움직이는 방법과 아래로 움직이는 방법 중 최소

            int next = i + 1;

            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            int rl = (i * 2) + name.length() - next; // 오른쪽으로 갔다가 왼쪽으로
            int lr = (name.length() - next) * 2 + i; // 왼쪽으로 갔다가 오른쪽으로

            leftRight = Math.min(leftRight, Math.min(rl, lr));
        }

        return upDown + leftRight;
    }
}