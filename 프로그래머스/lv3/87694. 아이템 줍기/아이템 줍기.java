import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        setBoard(rectangle);

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    public void setBoard(int[][] rectangle) {
        board = new int[101][101];
        visited = new boolean[101][101];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if (j == x1 || j == x2 || k == y1 || k == y2) {
                        if (board[j][k] == 2)
                            continue;
                        board[j][k] = 1;
                    } else {
                        board[j][k] = 2;
                    }
                }
            }
        }
    }

    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        visited[characterX][characterY] = true;
        q.add(new int[]{characterX, characterY, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];

            if (nowX == itemX && nowY == itemY) {
                return dist / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= 101 || ny < 0 || ny >= 101) continue;
                if (visited[nx][ny]) continue;
                
                if (board[nx][ny] == 1) {
                    q.add(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return 0;
    }
}