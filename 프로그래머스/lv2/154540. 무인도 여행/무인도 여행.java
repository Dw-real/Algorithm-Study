import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> answer;

    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        answer = new ArrayList<>();

        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'X')
                    map[i][j] = 0;
                else
                    map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    bfs(i, j, map);
                }
            }
        }
        if (answer.size() == 0)
            answer.add(-1);
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public void bfs(int x, int y, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int day = map[x][y];

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    day += map[nx][ny];
                }
            }
        }
        if (day != 0)
            answer.add(day);
    }

}