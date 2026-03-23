class Solution {
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static boolean[][] deleted;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] gameBoard = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = board[i].charAt(j);
            }
        }

        deleted = new boolean[m][n];

        while (true) {

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    checkBlock(i, j, gameBoard, deleted);
                }
            }
            int count = 0; // 지워지는 블록의 수

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (deleted[i][j]) {
                        count++;
                        gameBoard[i][j] = 'X';
                    }
                }
            }

            moveBlock(gameBoard);

            if (count == 0)
                break;

            answer += count;
            deleted = new boolean[m][n];
        }

        return answer;
    }

    public void checkBlock(int x, int y, char[][] board, boolean[][] deleted) {
        if (board[x][y] == 'X') return;
        
        boolean same = true;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (board[x][y] != board[nx][ny]) {
                same = false;
                break;
            }
        }

        if (same) {
            deleted[x][y] = true;
            deleted[x + dx[0]][y + dy[0]] = true;
            deleted[x + dx[1]][y + dy[1]] = true;
            deleted[x + dx[2]][y + dy[2]] = true;
        }
    }

    public void moveBlock(char[][] board) {
        int m = board.length; // 행의 수
        int n = board[0].length; // 열의 수

        // 각 열별로 처리
        for (int i = 0; i < n; i++) {
            int row = m - 1;

            for (int j = m - 1; j >= 0; j--) { // 아래에서 위로
                if (board[j][i] != 'X') {
                    board[row][i] = board[j][i];
                    row--;
                }
            }

            for (int j = row; j >= 0; j--) {
                board[j][i] = 'X';
            }
        }
    }
}