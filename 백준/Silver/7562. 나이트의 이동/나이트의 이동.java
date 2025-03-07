import java.io.*;
import java.util.*;

class Chess {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    int l; // 한변의 길이
    int[][] board;
    boolean[][] visited;

    public Chess(int l) {
        this.l = l;
        board = new int[l][l];
        visited = new boolean[l][l];
    }

    public int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == targetX && nowY == targetY)
                break;

            for (int i=0; i<8; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= l ||ny < 0 || ny >= l) continue;
                if (visited[nx][ny]) continue;

                board[nx][ny] = board[nowX][nowY] + 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return board[targetX][targetY];
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int l = Integer.parseInt(br.readLine());
            Chess c = new Chess(l);

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            bw.write(c.bfs(startX, startY, targetX, targetY) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
