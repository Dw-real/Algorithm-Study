class Solution {
    // 대각선, 세로
    static int[] dx = {-1, -1, -1};
    static int[] dy = {-1, 0, 1};
    static int[][] board;
    static int answer;

    public int solution(int n) {
        board = new int[n][n];
        answer = 0;
        dfs(0, n);

        return answer;
    }

    public void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        // row 행의 i열에 퀸을 놓아도 되는지 판단
        for (int i = 0; i < n; i++) {
            if (check(row, i, n)) {
                board[row][i] = 1;
                dfs(row + 1, n);
                board[row][i] = 0;
            }
        }
    }

    public boolean check(int row, int column, int n) {
        for (int i = 0; i < 3; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (board[nx][ny] == 1) { // 이미 퀸이 있다면 놓을 수 없음
                    return false;
                }
                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }
}