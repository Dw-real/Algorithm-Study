import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, num;
    static boolean[][] visited;
    static HashMap<Integer, Integer> oil;

    public void bfs(int[][] land, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        q.add(new int[]{x, y});
        land[x][y] = num;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            count++;
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                if (land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    land[nx][ny] = num;
                }
            }
        }

        oil.put(num, count);
    }

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        num = 2; // 석유가 있는 곳 라벨링
        oil = new HashMap<>(); // 각 위치에 있는 석유 양

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(land, i, j);
                    num++;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            HashSet<Integer> nums = new HashSet<>(); // 시추관을 설치한 위치에 있는 석유 덩어리 번호
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (land[j][i] > 0 && !nums.contains(land[j][i])) {
                    nums.add(land[j][i]);
                    count += oil.get(land[j][i]);
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}