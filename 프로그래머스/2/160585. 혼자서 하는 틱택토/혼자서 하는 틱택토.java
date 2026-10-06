class Solution {
    static boolean possible;
    static char[][] b;

    public int solution(String[] board) {
        possible = false;
        b = new char[3][3];

        // 게임판 초기화
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = '.';
            }
        }

        dfs(board, b, 0);

        return possible ? 1 : 0;
    }

    public void dfs(String[] board, char[][] b, int turn) {
        if (possible) return;

        if (isSame(board, b)) {
            possible = true;
            return;
        }
        if (isWin(b, 'O') || isWin(b, 'X') || turn == 9) {
            return;
        }

        char c = (turn % 2 == 0) ? 'O' : 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == '.') {
                    b[i][j] = c;
                    dfs(board, b, turn + 1);
                    b[i][j] = '.';
                }
            }
        }
    }

    public boolean isSame(String[] board, char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != b[i][j])
                    return false;
            }
        }

        return true;
    }

    public boolean isWin(char[][] b, char c) {
        // 가로 판정
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == c && b[i][1] == c && b[i][2] == c) {
                return true;
            }
        }

        // 세로 판정
        for (int i = 0; i < 3; i++) {
            if (b[0][i] == c && b[1][i] == c && b[2][i] == c) {
                return true;
            }
        }

        // 대각선 판정
        if (b[0][0] == c && b[1][1] == c && b[2][2] == c) return true;

        return b[0][2] == c && b[1][1] == c && b[2][0] == c;
    }
}