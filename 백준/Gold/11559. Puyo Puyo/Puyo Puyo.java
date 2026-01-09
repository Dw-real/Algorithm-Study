import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static boolean[][] visited;
    static boolean[][] crashed;

    static int bfs(int x, int y, char block, List<int[]> group) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        group.add(new int[]{x, y});
        int count = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            count++;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if (visited[nx][ny]) continue;

                if (board[nx][ny] == block) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    group.add(new int[]{nx, ny});
                }
            }
        }

        return count;
    }

    static void chainAction() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (crashed[i][j])
                    board[i][j] = '.';
            }
        }
    }

    static void movePuyo() {
        int h = board.length;
        int w = board[0].length;

        // 열별로 처리
        for (int i = 0; i < w; i++) {
            int row = h - 1;

            // 아래에서 위로
            for (int j = h - 1; j >= 0; j--) {
                if (board[j][i] != '.') {
                    board[row][i] = board[j][i];
                    row--;
                }
            }

            for (int j = row; j >= 0; j--) {
                board[j][i] = '.';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board = new char[12][6];

        for (int i = 0; i < board.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int count = 0;

        while (true) {
            visited = new boolean[12][6];
            crashed = new boolean[12][6];

            boolean flag = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!visited[i][j] && board[i][j] != '.') {
                        List<int[]> group = new ArrayList<>();
                        int linked = bfs(i, j, board[i][j], group);
                        if (linked >= 4) {
                            for (int[] pos : group) {
                                crashed[pos[0]][pos[1]] = true;
                            }
                            flag = true;
                        }
                    }
                }
            }

            if (!flag)
                break;
            chainAction();
            count++;
            // 연쇄 작용 후 뿌요 이동
            movePuyo();
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
