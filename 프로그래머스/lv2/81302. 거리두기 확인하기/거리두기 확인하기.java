import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] room;
    static Queue<int[]> q;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            q = new LinkedList<>();
            room = new char[5][5];

            for (int j = 0; j < 5; j++) {
                String str = place[j];
                for (int k = 0; k < 5; k++) {
                    room[j][k] = str.charAt(k);
                }
            }

            boolean obey = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (room[j][k] == 'P') {
                        if (!bfs(j, k)) {
                            obey = false;
                            break;
                        }
                    }
                }
            }

            if (obey) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public boolean bfs(int x, int y) {
        visited = new boolean[5][5];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny]) continue;

                if (room[nx][ny] == 'O') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count + 1});
                }
                if (room[nx][ny] == 'P') {
                    visited[nx][ny] = true;
                    if (count + 1 <= 2)
                        return false;
                    q.add(new int[]{nx, ny, count + 1});
                }
            }
        }

        return true;
    }
}