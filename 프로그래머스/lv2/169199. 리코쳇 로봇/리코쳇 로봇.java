import java.util.*;

class Solution {
    static int answer = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] visited;

    public int solution(String[] board) {
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        n = board.length;
        m = board[0].length();
        visited = new boolean[n][m];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                }
                else if (board[i].charAt(j) == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs(board, startX, startY, endX, endY);

        return answer;
    }

    public void bfs(String[] board, int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true; // 시작점 방문 처리

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            // 도착점에 도달했을 때 탐색 종료
            if (nowX == endX && nowY == endY) {
                answer = count;
                return;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                // 현재 방향으로 끝까지 이동
                while (isValid(nx, ny) && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 장애물 전 위치로 되돌림
                nx -= dx[i];
                ny -= dy[i];

                // 방문하지 않은 위치만 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count + 1});
                }
            }
        }
    }


    public boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}