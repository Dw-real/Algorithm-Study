import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static char[][] containers;
    static boolean[][] visited;
    static int n, m;


    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        count = 0;
        containers = new char[n + 2][m + 2];

        for (int i = 0; i < n; i++) {
            String s = storage[i];
            for (int j = 0; j < m; j++) {
                containers[i + 1][j + 1] = s.charAt(j);
            }
        }

        for (int i = 0; i <= n + 1; i++) {
            containers[i][0] = 'x';
            containers[i][m + 1] = 'x';
        }

        for (int i = 0; i <= m + 1; i++) {
            containers[0][i] = 'x';
            containers[n + 1][i] = 'x';
        }

        for (String request : requests) {
            char container = request.charAt(0);
            if (request.length() == 1) {
                useForkLift(container);
            } else {
                useCrain(container);
            }
        }

        return n * m - count;
    }

    public void useForkLift(char container) {
        visited = new boolean[n + 2][m + 2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx > n + 1 || ny < 0 || ny > m + 1) continue;
                if (visited[nx][ny]) continue;

                if (containers[nx][ny] == 'x') {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

                if (containers[nx][ny] == container) {
                    containers[nx][ny] = 'x';
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
    }

    public void useCrain(char container) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (containers[i][j] == container) {
                    containers[i][j] = 'x';
                    count++;
                }
            }
        }
    }
}