import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean flag = false;
    static int startX = 0, startY = 0, targetX = 0, targetY = 0, lX = 0, lY = 0;

    public int solution(String[] maps) {
        for (int i=0; i< maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    targetX = i;
                    targetY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lX = i;
                    lY = j;
                }
            }
        }

        int t1 = bfs(maps, startX, startY, lX, lY);

        if (!flag) return -1;

        flag = false;
        int t2 = bfs(maps, lX, lY, targetX, targetY);
        
        if (!flag) return -1;
        
        return t1 + t2;
    }

    public int bfs(String[] maps, int x, int y, int tX, int tY) {
        visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int time = now[2];

            if (nowX == tX && nowY == tY) {
                flag = true;
                return time;
            }

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[nx].length()) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx].charAt(ny) == 'X') continue;

                q.add(new int[]{nx, ny, time + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}