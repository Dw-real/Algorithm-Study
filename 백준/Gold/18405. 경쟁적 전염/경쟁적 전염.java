import java.io.*;
import java.util.*;

class Virus implements Comparable<Virus> {
    int n;
    int x;
    int y;
    int t;

    public Virus(int n, int x, int y, int t) {
        this.n = n;
        this.x = x;
        this.y = y;
        this.t = t;
    }

    @Override
    public int compareTo(Virus v) {
        return this.n - v.n;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n; // 시험관의 크기
    static int k; // 바이러스의 종류 수
    static int s, x, y;
    static int[][] tube;
    static PriorityQueue<Virus> pq;

    static void bfs() {
        int time = 0;
        while (!pq.isEmpty()) {
            if (time == s) return;
            time++;

            Queue<Virus> q = new LinkedList<>();
            int size = pq.size();
            while (--size >= 0) {
                Virus v = pq.poll();
                for (int i=0; i<4; i++) {
                    int nx = v.x + dx[i];
                    int ny = v.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (tube[nx][ny] != 0) continue;

                    tube[nx][ny] = v.n;
                    q.add(new Virus(v.n, nx, ny, v.t + 1));
                }
            }
            while (!q.isEmpty()) {
                pq.add(q.poll());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tube = new int[n][n];
        pq = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                if (tube[i][j] != 0) {
                    pq.add(new Virus(tube[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(tube[x - 1][y - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}