class Solution {
    public int solution(int n, int w, int num) {
        int count = 0;
        int[][] warehouse = new int[101][101];
        int start = 1;
        int startX = 99;
        int startY = 0;

        boolean direction = true; // true인 경우 오른쪽, false인 경우 왼쪽으로
        while (start <= n) {
            if (direction) {
                for (int i = 0; i < w && start <= n; i++) {
                    warehouse[startX][i] = start++;
                }
            } else {
                for (int i = w - 1; i >= 0 && start <= n; i--) {
                    warehouse[startX][i] = start++;
                }
            }
            direction = !direction;
            startX--;
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (warehouse[i][j] == num) {
                    startX = i;
                    startY = j;
                }
            }
        }

        while (warehouse[startX][startY] != 0) {
            count++;
            startX--;
        }
        return count;
    }
}