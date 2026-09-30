import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            if (nowX == maps.length - 1 && nowY == maps[0].length - 1)
                return count;
            
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if (visited[nx][ny]) continue;

                if (maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}