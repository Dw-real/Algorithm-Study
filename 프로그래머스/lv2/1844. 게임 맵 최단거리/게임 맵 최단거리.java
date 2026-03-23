import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == maps.length - 1 && now[1] == maps[0].length - 1) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if (visited[nx][ny]) continue;

                if (maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        return -1;

    }
}