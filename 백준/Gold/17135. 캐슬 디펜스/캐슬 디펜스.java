import java.io.*;
import java.util.*;

class Main {
    static int[][] board;
    static int n, m, d;
    static int max = 0;

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
                int archerX = n;
                int archerY = output[j];
                int minDist = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;

                for (int k = 0; k < copy.length; k++) {
                    for (int l = 0; l < copy[k].length; l++) {
                        if (copy[k][l] == 1) {
                            int dist = getDistance(archerX, archerY, k, l);
                            if (dist <= d) {
                                if (dist < minDist ||
                                        (dist == minDist && l < minY)) {
                                    minDist = dist;
                                    minX = k;
                                    minY = l;
                                }
                            }
                        }
                    }
                }
                if (minDist <= d) {
                    visited[minX][minY] = true;
                }
            }
            for (int r = 0; r < n; r++) {
                for (int u = 0; u < m; u++) {
                    if (visited[r][u]) {
                        copy[r][u] = 0;
                        count++;
                    }
                }
            }
            moveEnemy(copy);
        }
        max = Math.max(max, count);
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
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