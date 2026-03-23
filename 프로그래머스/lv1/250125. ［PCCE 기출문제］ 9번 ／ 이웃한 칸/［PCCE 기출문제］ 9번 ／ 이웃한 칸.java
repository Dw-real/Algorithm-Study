class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for (int i=0; i<4; i++) {
            int checkH = h + dx[i];
            int checkW = w + dy[i];

            if (checkH < 0 || checkH >= board.length || checkW < 0 || checkW >= board[0].length) continue;

            if (board[h][w].equals(board[checkH][checkW])) answer++;
        }

        return answer;
    }
}