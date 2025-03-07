import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static boolean[] visited;
    static ArrayList<Point> store;
    static Queue<Point> q;

    static boolean bfs(int fx, int fy) {
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (getDistance(p.x, p.y, fx, fy) <= 1000) {
                return true;
            }

            for (int i=0; i<store.size(); i++) {
                if (visited[i]) continue;
                
                int nx = store.get(i).x;
                int ny = store.get(i).y;

                if (getDistance(p.x, p.y, nx, ny) <= 1000) {
                    visited[i] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int tc=0; tc<t; tc++) {
            int n = Integer.parseInt(br.readLine()); // 맥주를 파는 편의점의 수
            visited = new boolean[n];
            q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 상근이네 집의 좌표
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            q.add(new Point(hx, hy));

            store = new ArrayList<>();
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                store.add(new Point(x, y));
            }

            st = new StringTokenizer(br.readLine(), " ");
            // 페스티벌의 좌표
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            if (bfs(fx, fy))
                bw.write("happy\n");
            else
                bw.write("sad\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}