import java.io.*;
import java.util.*;

class Main {
    static int[][] board;
    static int n, m, d;
    static int max = 0;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    static void batchSoldier(int[] output, int[] num, boolean[] check, int start, int depth) {
        if (depth == 3) {
            simulate(output);
            return;
        }
        for (int i = start; i < m; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = num[i];
                batchSoldier(output, num, check, i + 1, depth + 1);
                check[i] = false;
            }
        }
    }

    static void simulate(int[] output) {
        int[][] copy = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }

        int count = 0; // 궁수가 제거한 적의 수
        for (int i = 0; i < n; i++) {
            boolean[][] visited = new boolean[n][m];
            for (int j = 0; j < output.length; j++) {
                int archerY = output[j];

                int[] target = bfs(copy, archerY);
                if (target != null) {
                    visited[target[0]][target[1]] = true;
                }
            }
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < m; l++) {
                    if (visited[k][l]) {
                        copy[k][l] = 0;
                        count++;
                    }
                }
            }
            moveEnemy(copy);
        }
        max = Math.max(max, count);
    }

    static int[] bfs(int[][] arr, int archerY) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        q.add(new int[]{n - 1, archerY, 1});
        visited[n - 1][archerY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];

            if (dist > d) continue;

            if (arr[nowX][nowY] == 1) {
                return new int[]{nowX, nowY};
            }

            for (int i = 0; i < 3; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }
        return null;
    }

    static void moveEnemy(int[][] copy) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = copy[i - 1][j];
            }
        }
        for (int j = 0; j < m; j++) {
            copy[0][j] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 행의 수
        m = Integer.parseInt(st.nextToken()); // 열의 수
        d = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한

        board = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] output = new int[3];
        boolean[] check = new boolean[m];
        int[] pos = new int[m];
        for (int i = 0; i < m; i++) {
            pos[i] = i;
        }
        batchSoldier(output, pos, check, 0, 0);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}