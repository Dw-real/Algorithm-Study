import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int count;
    boolean broken;

    public Node(int x, int y, int count, boolean broken) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.broken = broken;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1, 1, false));
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int count = now.count;
            boolean broken = now.broken;

            if (nowX == n && nowY == m) {
                return count;
            }

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][0] && !broken) {
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, count + 1,  broken));
                    } else if (!visited[nx][ny][1] && broken) {
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, count + 1,  broken));
                    }
                }
                if (map[nx][ny] == 1) {
                    if (!visited[nx][ny][0] && !broken) {
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, count + 1,  true));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];

        for (int i=1; i<=n; i++) {
            String str = br.readLine();
            for (int j=1; j<=m; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }


        bw.write(bfs() + "\n");

        br.close();
        bw.close();
    }
}