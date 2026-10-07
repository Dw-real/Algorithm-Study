import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] visited;
    static int answer;
    static char[][] warehouse;

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        warehouse = new char[n + 2][m + 2]; // 창고 외부를 위해 가로 세로 2씩 크게 생성

        answer = n * m; // 처음 컨테이너 수

        for (int i = 0; i <= n + 1; i++) {
            warehouse[i][0] = 'x';
            warehouse[i][m + 1] = 'x';
        }

        for (int i = 0; i <= m + 1; i++) {
            warehouse[0][i] = 'x';
            warehouse[n + 1][i] = 'x';
        }

        for (int i = 0; i < n; i++) {
            String containers = storage[i];
            for (int j = 0; j < m; j++) {
                warehouse[i + 1][j + 1] = containers.charAt(j);
            }
        }

        for (String request : requests) {
            char container = request.charAt(0);
            // 요청이 'A'와 같이 길이가 1이면 지게차, 'BB'와 같이 길이가 2이면 크레인 사용
            if (request.length() == 1) {
                useForkLift(container);
            } else {
                useCrane(container);
            }
        }


        return answer;
    }

    public void useForkLift(char container) {
        visited = new boolean[n + 2][m + 2]; // 위치 방문 여부
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n + 2 || ny < 0 || ny >= m + 2) continue;
                if (visited[nx][ny]) continue;

                if (warehouse[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
                if (warehouse[nx][ny] == container) {
                    answer--;
                    visited[nx][ny] = true;
                    warehouse[nx][ny] = 'x';
                }
            }
        }
    }

    public void useCrane(char container) {
        for (int i = 0; i < warehouse.length; i++) {
            for (int j = 0; j < warehouse[i].length; j++) {
                if (warehouse[i][j] == container) {
                    warehouse[i][j] = 'x';
                    answer--;
                }
            }
        }
    }
}